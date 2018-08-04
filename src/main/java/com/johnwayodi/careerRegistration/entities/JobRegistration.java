package com.johnwayodi.careerRegistration.entities;


import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class JobRegistration extends AbstractModel{
    private Boolean appliedFor;
    @OneToOne
    private JobApplicant jobApplicant;
    @OneToOne
    private Job job;

    public Boolean getAppliedFor() {
        return appliedFor;
    }

    public void setAppliedFor(Boolean appliedFor) {
        this.appliedFor = appliedFor;
    }

    public JobApplicant getJobApplicant() {
        return jobApplicant;
    }

    public void setJobApplicant(JobApplicant jobApplicant) {
        this.jobApplicant = jobApplicant;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
