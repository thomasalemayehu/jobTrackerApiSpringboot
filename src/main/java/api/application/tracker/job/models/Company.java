package api.application.tracker.job.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Company {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String url;

    private String description;

    @Embedded
    private Location location;

    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.REMOVE},orphanRemoval = true)
    private List<Remark> remarks;

    public Company() {
    }

    public Company(String name, String url, String description, Location location, List<Remark> remarks) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.location = location;
        this.remarks = remarks;
    }

    public Company(String name, String url, String description, Location location) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.location = location;
        this.remarks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Remark> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<Remark> remark) {
        this.remarks = remark;
    }

    public void addRemark(Remark remark){
        this.remarks.add(remark);
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", location=" + location +
                ", remark=" + remarks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return id == company.id && Objects.equals(name, company.name) && Objects.equals(url, company.url) && Objects.equals(description, company.description) && Objects.equals(location, company.location) && Objects.equals(remarks, company.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, url, description, location, remarks);
    }
}
