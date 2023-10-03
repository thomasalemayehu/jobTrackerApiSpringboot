package api.application.tracker.job.services;


import api.application.tracker.job.exceptions.CompanyNotFoundException;
import api.application.tracker.job.models.Company;
import api.application.tracker.job.repositories.CompanyRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }


    public Company create(Company company){
        return companyRepository.save(company);
    }

    public List<Company> getAll(Pageable pageable){
        return companyRepository.findAll(pageable).getContent();
    }

    public Company getById(int companyId){
        Optional<Company> company = companyRepository.findById(companyId);

        try{
            return company.get();
        }catch (Exception e){
            throw new CompanyNotFoundException("Company with id " + companyId + " not found.");
        }
    }

    public List<Company> getByName(String companyName, Pageable pageable){
        return companyRepository.findByNameEquals(companyName,pageable).getContent();
    }

    public Company updateById(int companyId, Company newCompanyInfo){
        Company oldCompany = getById(companyId);

        if(!Objects.equals(oldCompany.getDescription(), newCompanyInfo.getDescription()) && newCompanyInfo.getDescription() != null){
            oldCompany.setDescription(newCompanyInfo.getDescription());
        }

        if(!Objects.equals(oldCompany.getLocation(), newCompanyInfo.getLocation()) && newCompanyInfo.getLocation() != null){
            oldCompany.setLocation(newCompanyInfo.getLocation());
        }

        if(!Objects.equals(oldCompany.getName(), newCompanyInfo.getName()) && newCompanyInfo.getName() != null){
            oldCompany.setName(newCompanyInfo.getName());
        }

        if(!Objects.equals(oldCompany.getRemarks(), newCompanyInfo.getRemarks()) && newCompanyInfo.getRemarks() != null){
            oldCompany.setRemarks(newCompanyInfo.getRemarks());
        }

        if(!Objects.equals(oldCompany.getUrl(), newCompanyInfo.getUrl()) && newCompanyInfo.getUrl() != null){
            oldCompany.setUrl(newCompanyInfo.getUrl());
        }

        create(oldCompany);
        return oldCompany;
    }

    public Company deleteById(int companyId){
        Company company = getById(companyId);
        companyRepository.deleteById(companyId);
        return company;
    }
}
