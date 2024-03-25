package com.embarkx.firstjobapp.job.repository;

import com.embarkx.firstjobapp.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
