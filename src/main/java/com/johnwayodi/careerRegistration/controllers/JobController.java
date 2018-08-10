package com.johnwayodi.careerRegistration.controllers;

import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.repos.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class JobController {

    private final JobRepository jobRepository;

    @Autowired
    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }


    @RequestMapping("/showSearchJobs")
    public String showSearchJobs(){
        return "searchJobs";
    }

    @RequestMapping("/searchJobs")
    public String searchJobs(@RequestParam("jobType") String jobType,
                             ModelMap modelMap){
        List<Job> jobList = jobRepository.findByJobType(jobType);
        modelMap.addAttribute("jobList", jobList);
        return "showJobs";
    }

}
