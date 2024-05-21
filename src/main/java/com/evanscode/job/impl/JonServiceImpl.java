package com.evanscode.job.impl;

import com.evanscode.job.Job;
import com.evanscode.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class JonServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<Job>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job getJobById(Long id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJobById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            Job job = iterator.next();
            if (job.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setTitle(updateJob.getTitle());
                job.setDescription(updateJob.getDescription());
                job.setMinSalary(updateJob.getMinSalary());
                job.setMaxSalary(updateJob.getMaxSalary());
                job.setLocation(updateJob.getLocation());
                return true;
            }
        }
        return false;
    }
}