package api.application.tracker.job.models;


import jakarta.persistence.Embeddable;

@Embeddable
public class Location {

    private String state;

    private String city;

    private String zipCode;


    public Location() {
    }

    public Location(String state, String city, String zipCode) {
        this.state = state;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Location{" +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
