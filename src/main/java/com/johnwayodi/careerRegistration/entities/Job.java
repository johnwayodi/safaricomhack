package com.johnwayodi.careerRegistration.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "JOB")
public class Job extends AbstractModel{

    @Column(name = "Job_Name",nullable = false) private String name;
    @Column(name = "Description",nullable = false) private String description;
    @Column(name = "Job_Type",nullable = false) private String jobType;
    @Column(name = "Years_Of_Experience",nullable = false) private int yearsOfExperience;
    @Column(name = "Education_Level",nullable = false) private String educationLevel;
    @Column(name = "Status",nullable = false) private Boolean status;

    @Temporal(TemporalType.DATE)
    @Column(name = "Interview_Date",nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date interviewDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIME)@Column(name = "Start_Time",nullable = false)
    private Date interviewStartTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIME)@Column(name = "End_Time",nullable = false)
    private Date interviewStopTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public Date getInterviewStartTime() {
        return interviewStartTime;
    }

    public void setInterviewStartTime(Date interviewStartTime) {
        this.interviewStartTime = interviewStartTime;
    }

    public Date getInterviewStopTime() {
        return interviewStopTime;
    }

    public void setInterviewStopTime(Date interviewStopTime) {
        this.interviewStopTime = interviewStopTime;
    }


}
