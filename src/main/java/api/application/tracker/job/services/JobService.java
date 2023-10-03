package api.application.tracker.job.services;


import api.application.tracker.job.exceptions.JobNotFoundException;
import api.application.tracker.job.models.Job;
import api.application.tracker.job.repositories.JobRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class JobService {

    private JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }


    public Job create(Job job){
        return jobRepository.save(job);
    }

    public List<Job> getAll(Pageable pageable){
        return jobRepository.findAll(pageable).getContent();
    }

    public Job getById(int jobId){
        Optional<Job> job = jobRepository.findById(jobId);

        try{
            return job.get();
        }catch (Exception e){
            throw  new JobNotFoundException("Job with id " + jobId + " not found");
        }
    }

    public List<Job> getByName(String position,Pageable pageable){
        return jobRepository.findByPosition(position,pageable).getContent();
    }

    public Job updateById(int jobId,Job newJobInfo){
        Job oldJob = getById(jobId);

        if(!Objects.equals(oldJob.getDescription(),newJobInfo.getDescription())){
            oldJob.setDescription(newJobInfo.getDescription());
        }
        if(!Objects.equals(oldJob.getPosition(),newJobInfo.getPosition())){
            oldJob.setPosition(newJobInfo.getPosition());
        }
        if(!Objects.equals(oldJob.getType(),newJobInfo.getType())){
            oldJob.setType(newJobInfo.getType());
        }

        if(!Objects.equals(oldJob.getRemarkList(),newJobInfo.getRemarkList())){
            oldJob.setRemarkList(newJobInfo.getRemarkList());
        }
        if(!Objects.equals(oldJob.getCompany(),newJobInfo.getCompany())){
            oldJob.setCompany(newJobInfo.getCompany());
        }

        if(!Objects.equals(oldJob.getExpectedSalary(),newJobInfo.getExpectedSalary())){
            oldJob.setExpectedSalary(newJobInfo.getExpectedSalary());
        }

        create(oldJob);
        return oldJob;
    }

    public Job deleteById(int jobId){
        Job job = getById(jobId);
        jobRepository.deleteById(jobId);
        return job;
    }
}
