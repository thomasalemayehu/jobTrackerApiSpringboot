package api.application.tracker.job.models.jobApplication;


import api.application.tracker.job.models.Remark;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AppliedJobApplication extends JobApplication {

    @Id
    @GeneratedValue
    private int id;
    private Date applicationDate;


    @OneToMany
    private List<Remark> preDescription;

    public AppliedJobApplication() {
    }

    public AppliedJobApplication(Date applicationDate, List<Remark> preDescription) {
        this.applicationDate = applicationDate;
        this.preDescription = preDescription;
    }

    public AppliedJobApplication(Date applicationDate) {
        this.applicationDate = applicationDate;
        this.preDescription = new ArrayList<>();
    }

    public void addDescription(Remark remark){
        this.preDescription.add(remark);
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public List<Remark> getPreDescription() {
        return preDescription;
    }

    public void setPreDescription(List<Remark> preDescription) {
        this.preDescription = preDescription;
    }

    @Override
    public String toString() {
        return "AppliedJobApplication{" +
                "id=" + id +
                ", applicationDate=" + applicationDate +
                ", preDescription=" + preDescription +
                '}';
    }
}
