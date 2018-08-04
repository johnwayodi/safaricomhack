package com.johnwayodi.careerRegistration.services;

import com.johnwayodi.careerRegistration.entities.JobApplicant;

import java.util.List;
import java.util.UUID;

public interface JobApplicantService {
    JobApplicant saveJobApplicant(JobApplicant jobApplicant);
    JobApplicant updateJobApplicant(JobApplicant jobApplicant);
    void deleteJobApplicant(JobApplicant jobApplicant);
    JobApplicant getJobApplicantById(UUID id);
    List<JobApplicant> getAllJobApplicants();
}
