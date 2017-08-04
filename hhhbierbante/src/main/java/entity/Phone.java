package entity;

import javax.persistence.*;

@Entity(name = "Phone")
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "number")
    private String number;

    @OneToOne
    @JoinColumn(name = "detailId")
    private PhoneDetails details;

    public Phone() {
    }

    public Phone(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public PhoneDetails getDetails() {
        return details;
    }

   /* public void addDetails(PhoneDetails details) {
        details.setPhone( this );
        this.details = details;
    }

    public void removeDetails() {
        if ( details != null ) {
            details.setPhone( null );
            this.details = null;
        }
    }*/

    public void setDetails(PhoneDetails details) {
        this.details = details;
    }
}
