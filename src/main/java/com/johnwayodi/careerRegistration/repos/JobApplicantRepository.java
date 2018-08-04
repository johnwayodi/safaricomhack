package com.johnwayodi.careerRegistration.repos;

import com.johnwayodi.careerRegistration.entities.JobApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobApplicantRepository extends JpaRepository<JobApplicant, UUID> {
}
