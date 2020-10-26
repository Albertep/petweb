package tutorialweb.petweb.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastname) {
        firstName = lastname;
    }
}
