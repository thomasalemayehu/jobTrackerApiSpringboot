package api.application.tracker.job.utils;


import api.application.tracker.job.models.Company;
import api.application.tracker.job.models.Location;
import api.application.tracker.job.models.Remark;
import api.application.tracker.job.models.types.RemarkType;
import api.application.tracker.job.services.CompanyService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    private CompanyService companyService;

    public CommandLineRunner(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Populating with data...");
        List<Company> companies = Arrays.asList(
                addGoogle(),
                addJaneStreet(),
                addAmazon(),
                addApple(),
                addFacebook(),
                addUber(),
                addLinkedin(),
                addDataBricks()
        );

        for(Company company: companies){
            companyService.create(company);
        }
        companies= Arrays.asList(
                addGoogle(),
                addJaneStreet(),
                addAmazon(),
                addApple(),
                addFacebook(),
                addUber(),
                addLinkedin(),
                addDataBricks()
        );
        for(Company company: companies){
            companyService.create(company);
        }
        companies= Arrays.asList(
                addGoogle(),
                addJaneStreet(),
                addAmazon(),
                addApple(),
                addFacebook(),
                addUber(),
                addLinkedin(),
                addDataBricks()
        );
        for(Company company: companies){
            companyService.create(company);
        }
        companies= Arrays.asList(
                addGoogle(),
                addJaneStreet(),
                addAmazon(),
                addApple(),
                addFacebook(),
                addUber(),
                addLinkedin(),
                addDataBricks()
        );
        for(Company company: companies){
            companyService.create(company);
        }
        System.out.println("Populated with data....");
    }


    public Company addGoogle(){
        Location location = new Location("California","San Fransisco","52556");
        Remark remark = new Remark(RemarkType.WARNING,"Prepare on leetcode");
        return new Company("Google","https://google.com","Google Description",location,Arrays.asList(remark));
    }

    public Company addAmazon(){
        Location location = new Location("California","San Jose","52556");
        Remark remark = new Remark(RemarkType.URGENT,"Prepare on leetcode");
        return new Company("Amazon","https://amazon.com","Amazon Description",location,Arrays.asList(remark));
    }

    public Company addFacebook(){
        Location location = new Location("California","San Jose","52556");
        Remark remark = new Remark(RemarkType.URGENT,"Prepare on leetcode");
        return new Company("Facebook","https://facebook.com","Facebook Description",location,Arrays.asList(remark));
    }

    public Company addApple(){
        Location location = new Location("New York","New York","52556");
        Remark remark = new Remark(RemarkType.URGENT,"Prepare on leetcode");
        return new Company("Apple","https://Apple.com","Apple Description",location,Arrays.asList(remark));
    }

    public Company addUber(){
        Location location = new Location("New York","New York","52556");
        Remark remark = new Remark(RemarkType.IGNORABLE,"Prepare on leetcode");
        return new Company("Uber","https://uber.com","Uber Description",location,Arrays.asList(remark));
    }

    public Company addLinkedin(){
        Location location = new Location("New York","New York","52556");
        Remark remark = new Remark(RemarkType.IGNORABLE,"Prepare on leetcode");
        return new Company("Linkedin","https://linkedin.com","Linkedin Description",location,Arrays.asList(remark));
    }


    public Company addJaneStreet(){
        Location location = new Location("California","San Fransisco","52556");
        Remark remark = new Remark(RemarkType.WARNING,"Prepare on leetcode");
        return new Company("Jane Street","https://janestreet.com","Jane Street Description",location,Arrays.asList(remark));
    }

    public Company addDataBricks(){
        Location location = new Location("California","San Fransisco","52556");
        Remark remark = new Remark(RemarkType.WARNING,"Prepare on leetcode");
        return new Company("Data Bricks","https://databricks.com","Data bricks Description",location,Arrays.asList(remark));
    }
}
