package com.embarkx.firstjobapp.job.service;

import com.embarkx.firstjobapp.job.model.Job;

import java.util.List;

public interface JobService {

    List<Job> findAll();
    void createJob(Job job);

    Job getById(Long id);

    boolean deleteJob(Long id);

    boolean updateJob(Long id, Job jobUpdate);
}
