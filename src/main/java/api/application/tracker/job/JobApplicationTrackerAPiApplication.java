package api.application.tracker.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobApplicationTrackerAPiApplication {

    public static void main(String[] args) {
        System.out.println("App Starting...");
        System.out.println();
        SpringApplication.run(JobApplicationTrackerAPiApplication.class, args);


        System.out.println();
        System.out.println("Application Ending...");

    }

}
