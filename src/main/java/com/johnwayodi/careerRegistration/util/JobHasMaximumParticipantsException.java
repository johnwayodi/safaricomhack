package com.johnwayodi.careerRegistration.util;

public class JobHasMaximumParticipantsException extends Exception{
    public JobHasMaximumParticipantsException(){
        super("Application failed, the Job you are trying to apply for has reached the maximum number of Applicants!!");
    }
}
