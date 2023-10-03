package api.application.tracker.job.models;


import api.application.tracker.job.models.types.JobType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Job {


    @Id
    @GeneratedValue
    private int id;


    @ManyToOne
    private Company company;

    private String position;

    private String description;


    private JobType type;


    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE})
    private List<Remark> remarkList;

    private double expectedSalary;

    public Job(){}

    public Job(String position, String description, JobType type, double expectedSalary,Company company) {
        this.position = position;
        this.description = description;
        this.type = type;
        this.remarkList = new ArrayList<>();
        this.expectedSalary = expectedSalary;
        this.company = company;
    }

    public Job(String position, String description, JobType type, List<Remark> remarkList, double expectedSalary,Company company) {
        this.position = position;
        this.description = description;
        this.type = type;
        this.remarkList = remarkList;
        this.expectedSalary = expectedSalary;
        this.company = company;
    }

    public void addRemark(Remark remark){
        this.remarkList.add(remark);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public List<Remark> getRemarkList() {
        return remarkList;
    }

    public void setRemarkList(List<Remark> remarkList) {
        this.remarkList = remarkList;
    }

    public double getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(double expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", remarkList=" + remarkList +
                ", expectedSalary=" + expectedSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id && Double.compare(expectedSalary, job.expectedSalary) == 0 && Objects.equals(company, job.company) && Objects.equals(position, job.position) && Objects.equals(description, job.description) && type == job.type && Objects.equals(remarkList, job.remarkList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, company, position, description, type, remarkList, expectedSalary);
    }
}
