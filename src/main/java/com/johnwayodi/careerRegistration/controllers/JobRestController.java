package com.johnwayodi.careerRegistration.controllers;

import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class JobRestController {

    private final JobService jobService;

    @Autowired
    public JobRestController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping(value = "/jobs/", method = RequestMethod.POST)
    public Job saveJob(@RequestBody Job job){
        job.setDateCreated(ZonedDateTime.now());
        return jobService.saveJob(job);
        }

    @RequestMapping(value = "/jobs/", method = RequestMethod.PUT)
    public Job updateJob(@RequestBody Job job){
        return jobService.updateJob(job);
    }

    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.DELETE)
    public void deleteJob(@PathVariable("id") UUID id){
        Job job = jobService.getJobById(id);
        jobService.deleteJob(job);
    }

    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.GET)
    public Job getJobById(@PathVariable("id") UUID id){
        return jobService.getJobById(id);
    }

    @RequestMapping(value = "/jobs/", method = RequestMethod.GET)
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }
}

