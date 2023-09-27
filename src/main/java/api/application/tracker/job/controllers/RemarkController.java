package api.application.tracker.job.controllers;


import api.application.tracker.job.models.Remark;
import api.application.tracker.job.services.RemarkService;
import api.application.tracker.job.utils.PaginationHandler;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remarks")
public class RemarkController {

    private RemarkService remarkService;

    private PaginationHandler paginationHandler;

    public RemarkController(RemarkService remarkService, PaginationHandler paginationHandler) {
        this.remarkService = remarkService;
        this.paginationHandler = paginationHandler;
    }

    @PostMapping("/")
    public Remark create(@RequestBody Remark remark){
        return remarkService.create(remark);
    }

    @GetMapping("/all")
    public List<Remark> getAll(@RequestParam(name = "page",required = false,defaultValue = "0")int pageNumber, @RequestParam(name = "size",defaultValue = "5",required = false) int pageSize){
        return remarkService.getAll(paginationHandler.getPageableInfo(pageNumber,pageSize));
    }

    @GetMapping("/{remarkId}")
    public Remark get(@PathVariable int remarkId){
        return remarkService.get(remarkId);
    }

    @PutMapping("/{remarkId}")
    public Remark update(@PathVariable int remarkId,@RequestBody Remark newRemarkInfo){
        return remarkService.update(remarkId,newRemarkInfo);
    }

    @DeleteMapping("/{remarkId}")
    public Remark delete(@PathVariable int remarkId){
        return remarkService.delete(remarkId);
    }

}
