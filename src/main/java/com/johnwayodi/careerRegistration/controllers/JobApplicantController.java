package com.johnwayodi.careerRegistration.controllers;

import com.johnwayodi.careerRegistration.entities.JobApplicant;
import com.johnwayodi.careerRegistration.repos.JobApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobApplicantController {

    private final JobApplicantRepository jobApplicantRepository;

    @Autowired
    public JobApplicantController(JobApplicantRepository jobApplicantRepository) {
        this.jobApplicantRepository = jobApplicantRepository;
    }

    @RequestMapping("/showRegistration")
    public String showRegistrationPage(){
        return "registration";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") JobApplicant jobApplicant){
        jobApplicantRepository.save(jobApplicant);
        return "login";
    }

    @RequestMapping("/showLogin")
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        ModelMap modelMap){
        JobApplicant jobApplicant = jobApplicantRepository.findByEmail(email);
        if (jobApplicant.getPassword().equals(password)){
            return "searchJobs";
        }else {
            modelMap.addAttribute("msg", "Incorrect password!! Try again");
        }
        return "login";
    }
}
