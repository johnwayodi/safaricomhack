package com.johnwayodi.careerRegistration.controllers;

import com.johnwayodi.careerRegistration.dto.JobRegistrationRequest;
import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.entities.JobRegistration;
import com.johnwayodi.careerRegistration.services.JobRegistrationService;
import com.johnwayodi.careerRegistration.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class JobRegistrationController {

    private final JobRegistrationService jobRegistrationService;

    private final JobService jobService;

    @Autowired
    public JobRegistrationController(JobRegistrationService jobRegistrationService, JobService jobService) {
        this.jobRegistrationService = jobRegistrationService;
        this.jobService = jobService;
    }

    @RequestMapping("/showApplication")
    public String showApplication(@RequestParam("jobId") UUID jobId,
                                          ModelMap modelMap){
        Job job = jobService.getJobById(jobId);
        modelMap.addAttribute("job", job);
        return "completeApplication";
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
