package api.application.tracker.job.repositories;

import api.application.tracker.job.models.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TechStackRepository extends JpaRepository<TechStack, Integer> {
}
