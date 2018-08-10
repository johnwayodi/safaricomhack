package com.johnwayodi.careerRegistration.controllers;

import com.johnwayodi.careerRegistration.entities.JobApplicant;
import com.johnwayodi.careerRegistration.repos.JobApplicantRepository;
import com.johnwayodi.careerRegistration.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@RestController
public class JobApplicantRestController {
    private final JobApplicantRepository jobApplicantRepository;

    @Autowired
    public JobApplicantRestController(JobApplicantRepository jobApplicantRepository) {
        this.jobApplicantRepository = jobApplicantRepository;
    }

    @GetMapping("/jobapplicants/{id}")
    public JobApplicant getJobById(@PathVariable("id") UUID applicantId){
        return jobApplicantRepository.findById(applicantId).map(jobApplicant ->
                jobApplicantRepository.getOne(applicantId)).orElseThrow(()->
                new ResourceNotFoundException("Applicant with id " + applicantId + " not found in database"));
    }

    @GetMapping("/jobapplicants/")
    public List<JobApplicant> getAllJobApplicants(){
        return jobApplicantRepository.findAll();
    }

    @PostMapping("/jobapplicants/")
    public JobApplicant saveJobApplicant(@RequestBody JobApplicant jobApplicant){
        jobApplicant.setDateCreated(ZonedDateTime.now());
        return jobApplicantRepository.save(jobApplicant);
    }

    @PutMapping("/jobapplicants/{id}")
    public JobApplicant updateJob(@PathVariable("id") UUID applicantId, @RequestBody JobApplicant jobApplicantTemp){
        return jobApplicantRepository.findById(applicantId).map(jobApplicant -> {
            jobApplicant.setFirstName(jobApplicantTemp.getFirstName());
            jobApplicant.setLastName(jobApplicantTemp.getLastName());
            jobApplicant.setEmail(jobApplicantTemp.getEmail());
            jobApplicant.setEducationLevel(jobApplicantTemp.getEducationLevel());
            jobApplicant.setPassword(jobApplicantTemp.getPassword());
            jobApplicant.setPhone(jobApplicantTemp.getPhone());
            jobApplicant.setYearsOfExperience(jobApplicantTemp.getYearsOfExperience());
            return jobApplicantRepository.save(jobApplicant);
        }).orElseThrow(()->
                new ResourceNotFoundException("Applicant with id " + applicantId + " not found in database"));
    }

    @DeleteMapping("/jobapplicants/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable("id") UUID applicantId){
        return jobApplicantRepository.findById(applicantId).map(jobApplicant ->{
            jobApplicantRepository.delete(jobApplicant);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Applicant with id: " + applicantId + " not found in database"));
    }

}
