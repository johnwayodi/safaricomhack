package com.johnwayodi.careerRegistration.services;

import com.johnwayodi.careerRegistration.dto.JobRegistrationRequest;
import com.johnwayodi.careerRegistration.entities.JobRegistration;

import java.util.UUID;

public interface JobRegistrationService {
    JobRegistration registerForInterview(JobRegistrationRequest request);
    void deregisterForInterview(UUID id);
}
