package api.application.tracker.job.repositories;


import api.application.tracker.job.models.Company;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer>, PagingAndSortingRepository<Company,Integer> {
    Page<Company> findAll(Pageable pageable);

    Page<Company> findByNameEquals(String companyName,Pageable pageable);


}
