package com.johnwayodi.careerRegistration.services;

import com.johnwayodi.careerRegistration.dto.JobRegistrationRequest;
import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.entities.JobApplicant;
import com.johnwayodi.careerRegistration.entities.JobRegistration;
import com.johnwayodi.careerRegistration.repos.JobApplicantRepository;
import com.johnwayodi.careerRegistration.repos.JobRegistrationRepository;
import com.johnwayodi.careerRegistration.repos.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JobRegistrationServiceImpl implements JobRegistrationService {

    private final JobApplicantRepository jobApplicantRepository;
    private final JobRepository jobRepository;
    private final JobRegistrationRepository jobRegistrationRepository;

    @Autowired
    public JobRegistrationServiceImpl(JobApplicantRepository jobApplicantRepository, JobRepository jobRepository, JobRegistrationRepository jobRegistrationRepository) {
        this.jobApplicantRepository = jobApplicantRepository;
        this.jobRepository = jobRepository;
        this.jobRegistrationRepository = jobRegistrationRepository;
    }

    @Override
    public JobRegistration registerForInterview(JobRegistrationRequest request) {

        JobApplicant jobApplicant = jobApplicantRepository.findByEmail(request.getApplicantEmail());
        Job job = jobRepository.getOne(request.getJobId());

        JobRegistration jobRegistration = new JobRegistration();
        jobRegistration.setJobApplicant(jobApplicant);
        jobRegistration.setJob(job);
        jobRegistration.setAppliedFor(true);

        return jobRegistrationRepository.save(jobRegistration);
    }

    @Override
    public void deregisterForInterview(UUID id) {
        JobRegistration jobRegistration = jobRegistrationRepository.findById(id).get();
        jobRegistrationRepository.delete(jobRegistration);
    }
}
