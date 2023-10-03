package api.application.tracker.job.models.jobApplication;

import api.application.tracker.job.models.Company;
import api.application.tracker.job.models.Job;
import api.application.tracker.job.models.Remark;
import api.application.tracker.job.models.TechStack;
import api.application.tracker.job.models.types.JobUrgency;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class JobApplication {

    @Id
    @GeneratedValue
    private int id;


    @ManyToOne
    private Company company;


    @OneToOne
    private Job job;


    @OneToOne
    private TechStack techStack;

    private String usedResumeFilePath;

    private String applicationSource;

    private String url;

    private Date deadline;

    @OneToMany
    private List<Remark> remarks;

    private JobUrgency urgency;

    public JobApplication() {
    }

    public JobApplication(Company company, Job job, TechStack techStack, String usedResumeFilePath, String applicationSource, String url, Date deadline, List<Remark> remarks, JobUrgency urgency) {
        this.company = company;
        this.job = job;
        this.techStack = techStack;
        this.usedResumeFilePath = usedResumeFilePath;
        this.applicationSource = applicationSource;
        this.url = url;
        this.deadline = deadline;
        this.remarks = remarks;
        this.urgency = urgency;
    }

    public JobApplication(Company company, Job job, TechStack techStack, String usedResumeFilePath, String applicationSource, String url, Date deadline, JobUrgency urgency) {
        this.company = company;
        this.job = job;
        this.techStack = techStack;
        this.usedResumeFilePath = usedResumeFilePath;
        this.applicationSource = applicationSource;
        this.url = url;
        this.deadline = deadline;
        this.urgency = urgency;
        this.remarks = new ArrayList<>();
    }

    public void addRemark(Remark remark){
        this.remarks.add(remark);
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public TechStack getTechStack() {
        return techStack;
    }

    public void setTechStack(TechStack techStack) {
        this.techStack = techStack;
    }

    public String getUsedResumeFilePath() {
        return usedResumeFilePath;
    }

    public void setUsedResumeFilePath(String usedResumeFilePath) {
        this.usedResumeFilePath = usedResumeFilePath;
    }

    public String getApplicationSource() {
        return applicationSource;
    }

    public void setApplicationSource(String applicationSource) {
        this.applicationSource = applicationSource;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public List<Remark> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<Remark> remarks) {
        this.remarks = remarks;
    }

    public JobUrgency getUrgency() {
        return urgency;
    }

    public void setUrgency(JobUrgency urgency) {
        this.urgency = urgency;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "JobApplication{" +
                "id=" + id +
                ", company=" + company +
                ", job=" + job +
                ", techStack=" + techStack +
                ", usedResumeFilePath='" + usedResumeFilePath + '\'' +
                ", applicationSource='" + applicationSource + '\'' +
                ", url='" + url + '\'' +
                ", deadline=" + deadline +
                ", remarks=" + remarks +
                ", urgency=" + urgency +
                '}';
    }
}
