package com.johnwayodi.careerRegistration.entities;


import javax.persistence.*;

@Entity
@Table(name = "JOB_REGISTRATION")
public class JobRegistration extends AbstractModel{

    @Column(name = "Booked",nullable = false)
    private Boolean booked;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Applicant_Id")
    private JobApplicant jobApplicant;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Job_Id")
    private Job job;

    public Boolean getBooked() {
        return booked;
    }

    public void setBooked(Boolean booked) {
        this.booked = booked;
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
