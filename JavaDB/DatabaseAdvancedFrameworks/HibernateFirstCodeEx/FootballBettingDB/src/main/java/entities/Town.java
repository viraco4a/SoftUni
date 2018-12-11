package entities;

import javax.persistence.*;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {
    private String name;
    private Country country;

    public Town() {
    }

    @Column(name = "name", nullable = false, unique = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(
            targetEntity = Country.class,
            cascade = CascadeType.ALL
    )
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
