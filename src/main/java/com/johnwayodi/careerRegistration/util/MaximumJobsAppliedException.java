package com.johnwayodi.careerRegistration.util;

public class MaximumJobsAppliedException extends Exception{
    public MaximumJobsAppliedException(){
        super("Application Failed, you have reached the maximum number of job applications!!");
    }
}
