package com.johnwayodi.careerRegistration.controllers;

import com.johnwayodi.careerRegistration.entities.JobApplicant;
import com.johnwayodi.careerRegistration.services.JobApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

public class JobApplicantRestController {
    private final JobApplicantService jobApplicantService;

    @Autowired
    public JobApplicantRestController(JobApplicantService jobApplicantService) {
        this.jobApplicantService = jobApplicantService;
    }

    @RequestMapping(value = "/jobapplicants/", method = RequestMethod.POST)
    public JobApplicant saveJobApplicant(@RequestBody JobApplicant jobApplicant){
        return jobApplicantService.saveJobApplicant(jobApplicant);
    }

    @RequestMapping(value = "/jobapplicants/", method = RequestMethod.PUT)
    public JobApplicant updateJob(@RequestBody JobApplicant jobApplicant){
        return jobApplicantService.updateJobApplicant(jobApplicant);
    }

    @RequestMapping(value = "/jobapplicants/{id}", method = RequestMethod.DELETE)
    public void deleteJob(@PathVariable("id") UUID id){
        JobApplicant jobApplicant = jobApplicantService.getJobApplicantById(id);
        jobApplicantService.deleteJobApplicant(jobApplicant);
    }

    @RequestMapping(value = "/jobapplicants/{id}", method = RequestMethod.GET)
    public JobApplicant getJobById(@PathVariable("id") UUID id){
        return jobApplicantService.getJobApplicantById(id);
    }

    @RequestMapping(value = "/jobapplicants/", method = RequestMethod.GET)
    public List<JobApplicant> getAllJobApplicants(){
        return jobApplicantService.getAllJobApplicants();
    }
}
