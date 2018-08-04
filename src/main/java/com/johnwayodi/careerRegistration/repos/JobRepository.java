package com.johnwayodi.careerRegistration.repos;

import com.johnwayodi.careerRegistration.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository extends JpaRepository<Job, UUID> {
    List<Job> findByJobType(String jobType);
}
