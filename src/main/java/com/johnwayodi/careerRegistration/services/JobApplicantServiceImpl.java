package com.johnwayodi.careerRegistration.services;

import com.johnwayodi.careerRegistration.entities.JobApplicant;
import com.johnwayodi.careerRegistration.repos.JobApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class JobApplicantServiceImpl implements JobApplicantService {

    private final JobApplicantRepository jobApplicantRepository;

    @Autowired
    public JobApplicantServiceImpl(JobApplicantRepository jobApplicantRepository) {
        this.jobApplicantRepository = jobApplicantRepository;
    }

    @Override
    public JobApplicant saveJobApplicant(JobApplicant jobApplicant) {
        return jobApplicantRepository.save(jobApplicant);
    }

    @Override
    public JobApplicant updateJobApplicant(JobApplicant jobApplicant) {
        return jobApplicantRepository.save(jobApplicant);
    }

    @Override
    public void deleteJobApplicant(JobApplicant jobApplicant) {
        jobApplicantRepository.delete(jobApplicant);
    }

    @Override
    public JobApplicant getJobApplicantById(UUID id) {
        return jobApplicantRepository.getOne(id);
    }

    @Override
    public List<JobApplicant> getAllJobApplicants() {
        return jobApplicantRepository.findAll();
    }
}
