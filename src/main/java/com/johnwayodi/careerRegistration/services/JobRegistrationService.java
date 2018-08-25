package com.johnwayodi.careerRegistration.services;

import com.johnwayodi.careerRegistration.dto.JobRegistrationRequest;
import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.entities.JobApplicant;
import com.johnwayodi.careerRegistration.entities.JobRegistration;
import com.johnwayodi.careerRegistration.util.JobHasMaximumParticipantsException;
import com.johnwayodi.careerRegistration.util.MaximumJobsAppliedException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface JobRegistrationService {
    JobRegistration registerForInterview(JobRegistrationRequest request) throws MaximumJobsAppliedException, JobHasMaximumParticipantsException;
    void deregisterForInterview(UUID id);
    Page<JobRegistration> getJobsForApplicant(UUID applicantId, Pageable pageable);
    Page<JobRegistration> getApplicantsForJob(UUID jobId, Pageable pageable);
}
