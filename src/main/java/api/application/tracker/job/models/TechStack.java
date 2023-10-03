package api.application.tracker.job.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TechStack stack = (TechStack) o;
        return id == stack.id && Objects.equals(language, stack.language) && Objects.equals(remark, stack.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, language, remark);
    }
}
