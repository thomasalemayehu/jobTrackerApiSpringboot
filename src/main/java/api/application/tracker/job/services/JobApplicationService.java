package api.application.tracker.job.services;


import api.application.tracker.job.exceptions.JobApplicationNotFoundException;
import api.application.tracker.job.models.jobApplication.JobApplication;
import api.application.tracker.job.repositories.JobApplicationRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    private JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public JobApplication create(JobApplication jobApplication){
        return jobApplicationRepository.save(jobApplication);
    }

    public List<JobApplication> getAll(Pageable pageable){
        return jobApplicationRepository.findAll(pageable).getContent();
    }

    public JobApplication getById(int jobApplicationId){
        Optional<JobApplication> jobApplication = jobApplicationRepository.findById(jobApplicationId);

        try{
            return jobApplication.get();
        }catch (Exception e){
            throw new JobApplicationNotFoundException("Job application with " + jobApplicationId + " not found.")
        }
    }

    public JobApplication deleteById(int jobApplicationId){
        JobApplication jobApplication = getById(jobApplicationId);

        jobApplicationRepository.deleteById(jobApplicationId);
        return jobApplication;
    }

}
