package api.application.tracker.job.controllers;


import api.application.tracker.job.models.Job;
import api.application.tracker.job.services.JobService;
import api.application.tracker.job.utils.PaginationHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    private final PaginationHandler paginationHandler;

    public JobController(JobService jobService, PaginationHandler paginationHandler) {
        this.jobService = jobService;
        this.paginationHandler = paginationHandler;
    }

    @PostMapping("/")
    public Job create(@RequestBody Job job){
        return jobService.create(job);
    }

    @GetMapping("/all")
    public List<Job> getAll(@RequestParam(name = "page",required = false,defaultValue = "0")int pageNumber, @RequestParam(name = "size",defaultValue = "5",required = false)int pageSize){
        return jobService.getAll(paginationHandler.getPageableInfo(pageNumber,pageSize));
    }

    @GetMapping("/{jobId}")
    public Job getById(@PathVariable int jobId){
        return jobService.getById(jobId);
    }

    @GetMapping("/")
    public List<Job> getByName(@RequestParam(name = "name") String position, @RequestParam(name = "page",defaultValue = "0",required = false)int pageNumber, @RequestParam(name = "size",required = false,defaultValue = "5")int pageSize){
        return jobService.getByName(position,paginationHandler.getPageableInfo(pageNumber,pageSize));
    }

    @PutMapping("/{jobId}")
    public Job updateById(@PathVariable int jobId, @RequestBody Job newJobInfo){
        return jobService.updateById(jobId,newJobInfo);
    }

    @DeleteMapping("/{jobId}")
    public Job deleteById(@PathVariable int jobId){
        return jobService.deleteById(jobId);
    }

}
