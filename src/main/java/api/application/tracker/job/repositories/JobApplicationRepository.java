package api.application.tracker.job.repositories;

import api.application.tracker.job.models.jobApplication.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication,Integer> {
}
