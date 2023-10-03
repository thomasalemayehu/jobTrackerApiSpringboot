package api.application.tracker.job.models;


import api.application.tracker.job.models.types.RemarkType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Objects;


@Entity
public class Remark {

    @Id
    @GeneratedValue
    private int id;

    private RemarkType descriptor;

    private String content;


    public Remark() {
    }

    public Remark(RemarkType descriptor, String content) {
        this.descriptor = descriptor;
        this.content = content;
    }

    public RemarkType getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(RemarkType descriptor) {
        this.descriptor = descriptor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Remark{" +
                "id=" + id +
                ", type=" + descriptor +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remark remark = (Remark) o;
        return id == remark.id && descriptor == remark.descriptor && Objects.equals(content, remark.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descriptor, content);
    }
}
