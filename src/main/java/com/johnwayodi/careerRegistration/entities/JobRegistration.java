package com.johnwayodi.careerRegistration.entities;


import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class JobRegistration extends AbstractModel{

    @OneToOne
    private JobApplicant jobApplicant;
    @OneToOne
    private Job job;

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
