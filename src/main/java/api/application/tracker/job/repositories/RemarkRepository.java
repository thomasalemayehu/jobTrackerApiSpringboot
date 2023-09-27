package api.application.tracker.job.repositories;

import api.application.tracker.job.models.Remark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RemarkRepository extends JpaRepository<Remark,Integer>, PagingAndSortingRepository<Remark,Integer> {
    Page<Remark> findAll(Pageable pageable);
}
