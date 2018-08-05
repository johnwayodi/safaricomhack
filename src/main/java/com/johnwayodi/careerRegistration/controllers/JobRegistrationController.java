package com.johnwayodi.careerRegistration.controllers;

import com.johnwayodi.careerRegistration.dto.JobRegistrationRequest;
import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.entities.JobRegistration;
import com.johnwayodi.careerRegistration.repos.JobRepository;
import com.johnwayodi.careerRegistration.services.JobRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class JobRegistrationController {

    private final JobRegistrationService jobRegistrationService;

    private final JobRepository jobRepository;

    @Autowired
    public JobRegistrationController(JobRegistrationService jobRegistrationService, JobRepository jobRepository) {
        this.jobRegistrationService = jobRegistrationService;
        this.jobRepository = jobRepository;
    }

    @RequestMapping("/showApplication")
    public String showApplication(@RequestParam("jobId") UUID jobId,
                                          ModelMap modelMap){
        Job job = jobRepository.getOne(jobId);
        modelMap.addAttribute("selectedJob", job);
        return "showApplication";
    }

    @RequestMapping(value = "completeApplication", method = RequestMethod.POST)
    public String completeReservation(JobRegistrationRequest request, ModelMap modelMap){
        JobRegistration jobRegistration = jobRegistrationService.registerForInterview(request);

        modelMap.addAttribute(
                "msg",
                "Interview Created Successfully, id is "+ jobRegistration.getId());

        return "applicationSuccess";
    }
}
