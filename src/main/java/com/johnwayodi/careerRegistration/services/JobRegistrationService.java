package com.johnwayodi.careerRegistration.services;

import com.johnwayodi.careerRegistration.dto.JobRegistrationRequest;
import com.johnwayodi.careerRegistration.entities.JobRegistration;
import com.johnwayodi.careerRegistration.util.JobHasMaximumParticipantsException;
import com.johnwayodi.careerRegistration.util.MaximumJobsAppliedException;

import java.util.UUID;

public interface JobRegistrationService {
    JobRegistration registerForInterview(JobRegistrationRequest request) throws MaximumJobsAppliedException, JobHasMaximumParticipantsException;
    void deregisterForInterview(UUID id);
}
