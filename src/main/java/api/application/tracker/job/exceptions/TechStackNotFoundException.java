package api.application.tracker.job.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TechStackNotFoundException extends RuntimeException{

    public TechStackNotFoundException(String message) {
        super(message);
    }
}
