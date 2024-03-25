package com.embarkx.firstjobapp.job.service.impl;

import com.embarkx.firstjobapp.job.model.Job;
import com.embarkx.firstjobapp.job.repository.JobRepository;
import com.embarkx.firstjobapp.job.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

 /*   private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {

        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId);
        jobs.add(job);
    }

    @Override
    public Job getById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJob(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()){
            Job job = iterator.next();
            if (job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job jobUpdate) {
        for (Job job:jobs) {
if (job.getId().equals(id)){
job.setTitle(jobUpdate.getTitle());
job.setDescription(jobUpdate.getDescription());
job.setMinSalary(job.getMinSalary());
job.setMaxSalary(jobUpdate.getMaxSalary());
job.setLocation(jobUpdate.getLocation());
return true;
}
        }
        return false;
    }*/


    //    private List<Job> jobs = new ArrayList<>();
    private final JobRepository jobs;
    //  private Long nextId = 1L;

    public JobServiceImpl(JobRepository jobs) {
        this.jobs = jobs;
    }

    @Override
    public List<Job> findAll() {

        return jobs.findAll();
    }

    @Override
    public void createJob(Job job) {
        //    job.setId(nextId);
        jobs.save(job);
    }

    @Override
    public Job getById(Long id) {
        return jobs.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJob(Long id) {
        try {
            jobs.deleteById(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean updateJob(Long id, Job jobUpdate) {
        Optional<Job> jobOptional = jobs.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            job.setTitle(jobUpdate.getTitle());
            job.setDescription(jobUpdate.getDescription());
            job.setMinSalary(job.getMinSalary());
            job.setMaxSalary(jobUpdate.getMaxSalary());
            job.setLocation(jobUpdate.getLocation());
            jobs.save(job);
            return true;
        }

        return false;
    }


}
