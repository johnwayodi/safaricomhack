package com.johnwayodi.careerRegistration.controllers;

import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.entities.JobApplicant;
import com.johnwayodi.careerRegistration.entities.JobRegistration;
import com.johnwayodi.careerRegistration.services.JobRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class JobRegistrationRestController {

    private final JobRegistrationService registrationService;

    @Autowired
    public JobRegistrationRestController(JobRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/jobapplicants/{applicantId}/jobs")
    public Page<Job> getJobsForApplicant(@PathVariable("applicantId") UUID applicantId,
                                         Pageable pageable){
        return registrationService.getJobsForApplicant(applicantId, pageable).map(JobRegistration::getJob);
    }

    @GetMapping("/jobs/{jobId}/applicants")
    public Page<JobApplicant> getApplicantsForJob(@PathVariable("jobId") UUID jobId,
                                                  Pageable pageable){
        return registrationService.getApplicantsForJob(jobId, pageable).map(JobRegistration::getJobApplicant);
    }
}
