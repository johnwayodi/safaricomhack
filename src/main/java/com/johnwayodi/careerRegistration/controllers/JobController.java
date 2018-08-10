package com.johnwayodi.careerRegistration.controllers;

import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.repos.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JobController {

    private final JobRepository jobRepository;

    @Autowired
    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @GetMapping("/searchJobs")
    public String showSearchJobs(){
        return "searchJobs";
    }

    @PostMapping("/searchJobs")
    public String searchJobs(@RequestParam("jobType") String jobType,
                             ModelMap modelMap){
        List<Job> jobList = jobRepository.findByJobType(jobType);
        modelMap.addAttribute("jobList", jobList);
        return "showJobs";
    }

}
