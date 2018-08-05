package com.johnwayodi.careerRegistration.controllers;

import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JobController {

    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @RequestMapping("/showSearchJobs")
    public String showSearchJobs(){
        return "searchJobs";
    }

    @RequestMapping("/searchJobs")
    public String searchJobs(@RequestParam("jobType") String jobType,
                             ModelMap modelMap){
        List<Job> jobList = jobService.getJobsByType(jobType);
        modelMap.addAttribute("jobList", jobList);
        return "showJobs";
    }

}
