package api.application.tracker.job.models.jobApplication;


import api.application.tracker.job.models.Remark;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class AcceptedJobApplication extends JobApplication{


    @Id
    @GeneratedValue
    private int id;

    private Date interviewDate;


    @OneToMany
    private List<Remark> prepRemarks;

    @OneToMany
    private List<Remark> interviewInfo;

    public AcceptedJobApplication() {
    }

    public AcceptedJobApplication(Date interviewDate) {
        this.interviewDate = interviewDate;
        this.prepRemarks = new ArrayList<>();
        this.interviewInfo = new ArrayList<>();
    }

    public AcceptedJobApplication(Date interviewDate, List<Remark> prepRemarks, List<Remark> interviewInfo) {
        this.interviewDate = interviewDate;
        this.prepRemarks = prepRemarks;
        this.interviewInfo = interviewInfo;
    }

    public void addPrepRemark(Remark remark){
        this.prepRemarks.add(remark);
    }

    public void addInterviewInfo(Remark remark){
        this.interviewInfo.add(remark);
    }

    public Date getInterviewDate() {
        return interviewDate;
    }

    public void setInterviewDate(Date interviewDate) {
        this.interviewDate = interviewDate;
    }

    public List<Remark> getPrepRemarks() {
        return prepRemarks;
    }

    public void setPrepRemarks(List<Remark> prepRemarks) {
        this.prepRemarks = prepRemarks;
    }

    public List<Remark> getInterviewInfo() {
        return interviewInfo;
    }

    public void setInterviewInfo(List<Remark> interviewInfo) {
        this.interviewInfo = interviewInfo;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AcceptedJobApplication{" +
                "id=" + id +
                ", interviewDate=" + interviewDate +
                ", prepRemarks=" + prepRemarks +
                ", interviewInfo=" + interviewInfo +
                '}';
    }
}
