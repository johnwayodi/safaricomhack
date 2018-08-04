package com.johnwayodi.careerRegistration.dto;

import java.util.UUID;

public class JobRegistrationRequest {


    private String applicantEmail;
    private UUID jobId;



    public String getApplicantEmail() {
        return applicantEmail;
    }

    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }

    public UUID getJobId() {
        return jobId;
    }

    public void setJobId(UUID jobId) {
        this.jobId = jobId;
    }
}
