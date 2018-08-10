package com.johnwayodi.careerRegistration.util;

public class JobHasMaximumParticipantsException extends Exception{
    public JobHasMaximumParticipantsException(){
        super();
    }

    public JobHasMaximumParticipantsException(String message){
        super(message);
    }

    public JobHasMaximumParticipantsException(String message, Throwable cause){
        super(message, cause);
    }
}
