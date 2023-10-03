package api.application.tracker.job.controllers;


import api.application.tracker.job.models.Job;
import api.application.tracker.job.models.jobApplication.JobApplication;
import api.application.tracker.job.services.JobApplicationService;
import api.application.tracker.job.utils.PaginationHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobApplications")
public class JobApplicationController {

    private final JobApplicationService jobApplicationService;

    private final PaginationHandler paginationHandler;


    public JobApplicationController(JobApplicationService jobApplicationService, PaginationHandler paginationHandler) {
        this.jobApplicationService = jobApplicationService;
        this.paginationHandler = paginationHandler;
    }

    @PostMapping("/")
    public JobApplication create(@RequestBody JobApplication jobApplication){
        return jobApplicationService.create(jobApplication);
    }

    @GetMapping("/all")
    public List<JobApplication> getAll(@RequestParam(name = "page",defaultValue = "0",required = false) int pageNumber, @RequestParam(name = "size",defaultValue = "5",required = false) int pageSize){
        return jobApplicationService.getAll(paginationHandler.getPageableInfo(pageNumber,pageSize));
    }

    @GetMapping("/{jobApplicationId}")
    public JobApplication getById(@PathVariable int jobApplicationId){
        return jobApplicationService.getById(jobApplicationId);
    }

    public JobApplication updateById(@PathVariable int jobApplicationId, JobApplication newJobApplicationInfo){
        JobApplication application = getById(jobApplicationId);

        // perform update

        create(application);
        return application;
    }


    public JobApplication deleteById(@PathVariable int jobApplicationId){
        return jobApplicationService.deleteById(jobApplicationId);
    }

}
