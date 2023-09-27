package api.application.tracker.job.controllers;


import api.application.tracker.job.models.Company;
import api.application.tracker.job.services.CompanyService;
import api.application.tracker.job.utils.PaginationHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    private final PaginationHandler paginationHandler;

    public CompanyController(CompanyService companyService, PaginationHandler paginationHandler) {
        this.companyService = companyService;
        this.paginationHandler = paginationHandler;
    }

    @PostMapping("/")
    public Company create(@RequestBody Company company){
        return companyService.create(company);
    }

    @GetMapping("/all")
    public List<Company> getAll(@RequestParam(name = "page",required = false,defaultValue = "0")int pageNumber, @RequestParam(name = "size",defaultValue = "5",required = false) int pageSize){
        return companyService.getAll(paginationHandler.getPageableInfo(pageNumber,pageSize));
    }

    @GetMapping("/{companyId}")
    public Company companyById(@PathVariable int companyId){
        return companyService.getById(companyId);
    }

    @GetMapping("/")
    public List<Company> companiesByName(@RequestParam(name = "name") String name, @RequestParam(name = "page",defaultValue = "0",required = false) int pageNumber, @RequestParam(name = "size",defaultValue = "5",required = false) int pageSize){
        return companyService.getByName(name, paginationHandler.getPageableInfo(pageNumber,pageSize));
    }

    @PutMapping("/{companyId}")
    public Company updateById(@PathVariable int companyId, @RequestBody Company company){
        return companyService.updateById(companyId,company);
    }

    @DeleteMapping("/{companyId}")
    public Company deleteById(@PathVariable int companyId){
        return companyService.deleteById(companyId);
    }
}
