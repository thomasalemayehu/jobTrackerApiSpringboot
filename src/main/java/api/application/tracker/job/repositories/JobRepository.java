package api.application.tracker.job.repositories;

import api.application.tracker.job.models.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepository extends JpaRepository<Job,Integer>, PagingAndSortingRepository<Job,Integer> {
    Page<Job> findAll(Pageable pageable);

    Page<Job> findByPosition(String position,Pageable pageable);
}
