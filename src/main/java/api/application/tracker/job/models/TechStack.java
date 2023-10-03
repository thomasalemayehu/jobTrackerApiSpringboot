package api.application.tracker.job.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class TechStack {

    @Id
    @GeneratedValue
    private int id;

    private String language;

    @OneToMany
    private List<Remark> remark;

    public TechStack() {
    }

    public TechStack(String language, List<Remark> remark) {
        this.language = language;
        this.remark = remark;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Remark> getRemark() {
        return remark;
    }

    public void setRemark(List<Remark> remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TechStack{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", remark=" + remark +
                '}';
    }
}
