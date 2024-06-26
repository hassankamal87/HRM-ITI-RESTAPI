package com.rest_hrm.business.service;

import com.rest_hrm.business.dto.JobDto;
import com.rest_hrm.business.mappers.JobMapper;
import com.rest_hrm.persistence.connection.JPAManager;
import com.rest_hrm.persistence.entities.Job;
import com.rest_hrm.persistence.repo.JobRepo;
import jakarta.persistence.EntityManager;

import java.util.List;

public class JobService {
    EntityManager em;
    JobRepo jobRepo;

    public JobService() {
        em = JPAManager.INSTANCE.getEntityManagerFactory().createEntityManager();
        jobRepo = new JobRepo(em);
    }


    public List<JobDto> getAllJobs() {
        List<Job> jobs = jobRepo.findAll(Job.class);
        return jobs.stream()
                .map(job -> JobMapper.getInstance().mapEntityToDto(job, JobDto.class))
                .toList();
    }

    public JobDto getJobById(int id) {
        Job job = jobRepo.findById(Job.class, id);
        if (job != null)
            return JobMapper.getInstance().mapEntityToDto(job, JobDto.class);
        return null;
    }


    public JobDto createJob(JobDto jobDto) {
        if (jobDto.getJobTitle().isEmpty())
            return null;
        Job newJob = new Job();
        newJob.setJobTitle(jobDto.getJobTitle());
        newJob = jobRepo.save(newJob);
        jobDto.setId(newJob.getId());
        return jobDto;
    }

    public void deleteJobById(int id){
        jobRepo.deleteById(Job.class, id);
    }
}
