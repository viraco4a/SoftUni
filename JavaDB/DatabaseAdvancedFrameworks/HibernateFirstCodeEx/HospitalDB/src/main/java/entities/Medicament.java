package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medicaments")
public class Medicament extends BaseEntity {

    private String name;
    private Set<Patient> patients;

    public Medicament() {
    }

    @Column(name = "name", nullable = false, length = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(
            targetEntity = Patient.class,
            mappedBy = "prescriptions",
            cascade = CascadeType.ALL
    )
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
