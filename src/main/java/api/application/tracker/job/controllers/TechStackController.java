package api.application.tracker.job.controllers;


import api.application.tracker.job.models.TechStack;
import api.application.tracker.job.services.TechStackService;
import api.application.tracker.job.utils.PaginationHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/stacks")
public class TechStackController {
    private final TechStackService techStackService;

    private final PaginationHandler paginationHandler;

    public TechStackController(TechStackService techStackService, PaginationHandler paginationHandler) {
        this.techStackService = techStackService;
        this.paginationHandler = paginationHandler;
    }

    @PostMapping("/")
    public TechStack create(@RequestBody TechStack techStack){
        return techStackService.create(techStack);
    }

    @GetMapping("/all")
    public List<TechStack> getAll(@RequestParam(name = "page")int pageNumber, @RequestParam(name = "size")int pageSize){
        return techStackService.getAll(paginationHandler.getPageableInfo(pageNumber,pageSize));
    }

    @GetMapping("/{techStackId}")
    public TechStack getById(@PathVariable int techStackId){
        return techStackService.getById(techStackId);
    }

    @PutMapping("/{techStackId}")
    public TechStack updateById(@PathVariable int techStackId, @RequestBody TechStack newTechStackInfo){
        TechStack techStack = getById(techStackId);

        if(!Objects.equals(techStack.getLanguage(),newTechStackInfo.getLanguage()) && newTechStackInfo.getLanguage() != null){
            techStack.setLanguage(newTechStackInfo.getLanguage());
        }
        if(!Objects.equals(techStack.getRemark(),newTechStackInfo.getRemark()) && newTechStackInfo.getRemark() != null){
            techStack.setRemark(newTechStackInfo.getRemark());
        }

        create(techStack);
        return techStack;
    }

    @DeleteMapping("/{companyId}")
    public TechStack deleteById(@PathVariable int companyId){
        return techStackService.deleteById(companyId);
    }

}
