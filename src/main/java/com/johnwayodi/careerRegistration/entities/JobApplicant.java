package com.johnwayodi.careerRegistration.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "JOB_APPLICANT")
public class JobApplicant extends AbstractModel{

    @Column(name = "First_Name",nullable = false)
    private String firstName;
    @Column(name = "Last_Name",nullable = false)
    private String lastName;
    @Column(name = "Email",nullable = false)
    private String email;
    @Column(name = "Password",nullable = false)
    private String password;
    @Column(name = "Phone",nullable = false)
    private String phone;
    @Column(name = "Education_Level",nullable = false)
    private String educationLevel;
    @Column(name = "Years_Of_Experience",nullable = false)
    private int yearsOfExperience;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
