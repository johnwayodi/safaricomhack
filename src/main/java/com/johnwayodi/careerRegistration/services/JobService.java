package com.johnwayodi.careerRegistration.services;

import com.johnwayodi.careerRegistration.entities.Job;

import java.util.List;
import java.util.UUID;

public interface JobService {
    Job saveJob(Job job);
    Job updateJob(Job job);
    void deleteJob(Job job);
    Job getJobById(UUID id);
    List<Job> getAllJobs();

    List<Job> getJobsByType(String jobType);
}
