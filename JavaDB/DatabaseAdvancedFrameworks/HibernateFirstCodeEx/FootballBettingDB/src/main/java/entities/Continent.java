package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "continents")
public class Continent extends BaseEntity{
    private String name;
    private Set<Country> countries;

    public Continent() {
    }

    @Column(name = "name", unique = true, nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    @JoinTable(
            name = "continents_countries",
            joinColumns = @JoinColumn(
                    name = "continent_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "country_id",
                    referencedColumnName = "id")
    )
    public Set<Country> getCountries() {
        return countries;
    }
    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }
}
