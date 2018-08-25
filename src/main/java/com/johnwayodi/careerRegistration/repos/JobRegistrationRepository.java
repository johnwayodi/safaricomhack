package com.johnwayodi.careerRegistration.repos;

import com.johnwayodi.careerRegistration.entities.Job;
import com.johnwayodi.careerRegistration.entities.JobApplicant;
import com.johnwayodi.careerRegistration.entities.JobRegistration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRegistrationRepository extends JpaRepository<JobRegistration, UUID> {

    Page<JobRegistration> findAllByJobApplicantEquals(JobApplicant applicant, Pageable pageable);
    Page<JobRegistration> findAllByJobEquals(Job job, Pageable pageable);

}
