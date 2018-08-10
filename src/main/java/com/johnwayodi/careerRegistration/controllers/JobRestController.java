package com.johnwayodi.careerRegistration.controllers;

import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.repos.JobRepository;
import com.johnwayodi.careerRegistration.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@RestController
public class JobRestController {

    private final JobRepository jobRepository;

    @Autowired
    public JobRestController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable("id") UUID jobId){
        return jobRepository.findById(jobId).map(job ->
                jobRepository.getOne(jobId)).orElseThrow(()->
                new ResourceNotFoundException("Job with id: " + jobId+ " not found in database"));
    }

    @GetMapping("/jobs/")
    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    @PostMapping("/jobs/")
    public Job createJob(@RequestBody Job job){
        job.setDateCreated(ZonedDateTime.now());
        return jobRepository.save(job);
        }

    @PutMapping("/jobs/{id}")
    public Job updateJob(@PathVariable("id") UUID  jobId, @RequestBody Job jobTemp){
        return jobRepository.findById(jobId).map(job ->{
            job.setName(jobTemp.getName());
            job.setDescription(jobTemp.getDescription());
            job.setJobType(jobTemp.getJobType());
            job.setEducationLevel(jobTemp.getEducationLevel());
            job.setInterviewDate(jobTemp.getInterviewDate());
            job.setInterviewStartTime(jobTemp.getInterviewStartTime());
            job.setInterviewStopTime(jobTemp.getInterviewStopTime());
            return jobRepository.save(job);
        }).orElseThrow(()-> new ResourceNotFoundException("Job with id: " + jobId + " not found in database"));
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable("id") UUID jobId){
        return jobRepository.findById(jobId).map(job ->{
            jobRepository.delete(job);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Job with id: " + jobId + " not found in database"));
    }

}

