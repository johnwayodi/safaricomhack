package com.johnwayodi.careerRegistration.controllers;

import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.entities.JobApplicant;
import com.johnwayodi.careerRegistration.entities.JobRegistration;
import com.johnwayodi.careerRegistration.repos.JobApplicantRepository;
import com.johnwayodi.careerRegistration.repos.JobRegistrationRepository;
import com.johnwayodi.careerRegistration.repos.JobRepository;
import com.johnwayodi.careerRegistration.services.JobRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

@Controller
public class JobApplicantController {

    private final JobApplicantRepository jobApplicantRepository;
    private final JobRegistrationRepository jobRegistrationRepository;
    private final JobRepository jobRepository;

    @Autowired
    public JobApplicantController(JobApplicantRepository jobApplicantRepository,
                                  JobRegistrationRepository jobRegistrationRepository,
                                  JobRepository jobRepository) {
        this.jobApplicantRepository = jobApplicantRepository;
        this.jobRegistrationRepository = jobRegistrationRepository;
        this.jobRepository = jobRepository;
    }

    @GetMapping("/register")
    public String showRegistrationPage(){
        return "registration";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") JobApplicant jobApplicant){
        jobApplicant.setDateCreated(ZonedDateTime.now());
        jobApplicantRepository.save(jobApplicant);
        return "login";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        ModelMap jobsBooked,
                        ModelMap jobTypes){
        JobApplicant jobApplicant = jobApplicantRepository.findByEmail(email);
        if (jobApplicant.getPassword().equals(password)){

            List<JobRegistration> jobsAlreadyApplied = jobRegistrationRepository.findAllByJobApplicantEquals(jobApplicant);
            jobsBooked.addAttribute("jobsApplied", jobsAlreadyApplied);

            Map<String, List<Job>> listOfJobTypes = jobsByType(jobRepository.findAll().stream());
            List<String> types = new ArrayList<>();
            types.addAll(listOfJobTypes.keySet());
            jobTypes.addAttribute("typesOfJobs", types);
            return "searchJobs";
        }else {
            jobsBooked.addAttribute("msg", "Incorrect Password!! Please Try again");
        }
        return "login";
    }

    public Map<String, List<Job>> jobsByType(Stream<Job> jobStream) {
        return jobStream.collect(groupingBy(Job::getJobType)); }
}
