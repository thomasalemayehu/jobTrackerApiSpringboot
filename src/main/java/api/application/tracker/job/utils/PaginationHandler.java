package api.application.tracker.job.utils;


import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Pageable;

@Component
public class PaginationHandler {
    public Pageable getPageableInfo(int pageNumber, int pageSize){
        return PageRequest.of(pageNumber,pageSize);
    }

    public Pageable getPageableInfo(){
        return PageRequest.of(1,3);
    }
}
