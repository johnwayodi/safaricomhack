package com.johnwayodi.careerRegistration.repos;

import com.johnwayodi.careerRegistration.entities.JobRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobRegistrationRepository extends JpaRepository<JobRegistration, UUID> {
}
