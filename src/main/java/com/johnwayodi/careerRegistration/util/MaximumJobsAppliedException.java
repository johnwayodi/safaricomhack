package com.johnwayodi.careerRegistration.util;

public class MaximumJobsAppliedException extends Exception{
    public MaximumJobsAppliedException(){
        super();
    }

    public MaximumJobsAppliedException(String message){
        super(message);
    }

    public MaximumJobsAppliedException(String message, Throwable cause){
        super(message, cause);
    }


}
