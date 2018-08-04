package com.johnwayodi.careerRegistration.services;

import com.johnwayodi.careerRegistration.dto.JobRegistrationRequest;
import com.johnwayodi.careerRegistration.entities.JobRegistration;

public interface JobRegistrationService {
    public JobRegistration registerForInterview(JobRegistrationRequest request);
}
