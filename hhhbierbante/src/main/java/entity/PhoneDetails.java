package entity;

import javax.persistence.*;

@Entity(name = "PhoneDetails")
public class PhoneDetails {

    @Id
    @GeneratedValue
    private Long id;

    private String provider;

    private String technology;

    public PhoneDetails() {
    }

    public PhoneDetails(String provider, String technology) {
        this.provider = provider;
        this.technology = technology;
    }

    public String getProvider() {
        return provider;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }


}