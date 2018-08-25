package com.johnwayodi.careerRegistration.services;

import com.johnwayodi.careerRegistration.dto.JobRegistrationRequest;
import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.entities.JobApplicant;
import com.johnwayodi.careerRegistration.entities.JobRegistration;
import com.johnwayodi.careerRegistration.repos.JobApplicantRepository;
import com.johnwayodi.careerRegistration.repos.JobRegistrationRepository;
import com.johnwayodi.careerRegistration.repos.JobRepository;
import com.johnwayodi.careerRegistration.util.JobHasMaximumParticipantsException;
import com.johnwayodi.careerRegistration.util.MaximumJobsAppliedException;
import com.johnwayodi.careerRegistration.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class JobRegistrationServiceImpl implements JobRegistrationService {

    private final JobApplicantRepository jobApplicantRepository;
    private final JobRepository jobRepository;
    private final JobRegistrationRepository jobRegistrationRepository;
    private static final int MAXIMUM_NUMBER_OF_APPLICATIONS = 3;
    private static final int MAXIMUM_NUMBER_OF_APPLICANTS = 20;

    @Autowired
    public JobRegistrationServiceImpl (JobApplicantRepository jobApplicantRepository, JobRepository jobRepository, JobRegistrationRepository jobRegistrationRepository) {
        this.jobApplicantRepository = jobApplicantRepository;
        this.jobRepository = jobRepository;
        this.jobRegistrationRepository = jobRegistrationRepository;
    }

    @Override
    public JobRegistration registerForInterview(JobRegistrationRequest request) throws MaximumJobsAppliedException, JobHasMaximumParticipantsException {

        JobApplicant jobApplicant = jobApplicantRepository.findByEmail(request.getApplicantEmail());
        Job job = jobRepository.getOne(request.getJobId());

        long jobsRegisteredByApplicant = jobRegistrationRepository.findAllByJobApplicantEquals(jobApplicant,
                Pageable.unpaged()).getTotalElements();

        long applicationsForJob = jobRegistrationRepository.findAllByJobEquals(job,
                Pageable.unpaged()).getTotalElements();

        if (jobsRegisteredByApplicant < MAXIMUM_NUMBER_OF_APPLICATIONS){
            if (applicationsForJob < MAXIMUM_NUMBER_OF_APPLICANTS){

                JobRegistration jobRegistration = new JobRegistration();
                jobRegistration.setJobApplicant(jobApplicant);
                jobRegistration.setJob(job);
                jobRegistration.setBooked(true);
                jobRegistration.setDateCreated(ZonedDateTime.now());
                return jobRegistrationRepository.save(jobRegistration);
            }else {
                throw (new JobHasMaximumParticipantsException());
            }

        }else {
            throw (new MaximumJobsAppliedException());
        }
    }

    @Override
    public void deregisterForInterview(UUID id) {
        JobRegistration jobRegistration = jobRegistrationRepository.findById(id).get();
        jobRegistrationRepository.delete(jobRegistration);
    }

    @Override
    public Page<JobRegistration> getJobsForApplicant(UUID applicantId, Pageable pageable) {

        return jobApplicantRepository.findById(applicantId).map(jobApplicant ->
                jobRegistrationRepository.findAllByJobApplicantEquals(jobApplicant,pageable)).orElseThrow(()->
                new ResourceNotFoundException("Applicant with id: " + applicantId + " not found in database"));
    }

    @Override
    public Page<JobRegistration> getApplicantsForJob(UUID jobId, Pageable pageable) {

        return jobRepository.findById(jobId).map(job ->
                jobRegistrationRepository.findAllByJobEquals(job,pageable)).orElseThrow(()->
                new ResourceNotFoundException("Job with id: " + jobId + " not found in database"));
    }

}
