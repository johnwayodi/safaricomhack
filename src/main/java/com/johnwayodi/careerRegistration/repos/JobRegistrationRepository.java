package com.johnwayodi.careerRegistration.repos;

import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.entities.JobApplicant;
import com.johnwayodi.careerRegistration.entities.JobRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRegistrationRepository extends JpaRepository<JobRegistration, UUID> {

    List<JobRegistration> findAllByJobApplicantEquals(JobApplicant jobApplicant);
    List<JobRegistration> findAllByJobEquals(Job job);

}
