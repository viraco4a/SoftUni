package entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {
    private String name;
    private String comments;
    private Set<Patient> patients;

    public Diagnose() {
    }

    @Column(name = "name", nullable = false, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "comment", length = 100)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToMany(
            targetEntity = Patient.class,
            mappedBy = "diagnoses",
            cascade = CascadeType.ALL
    )
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }
}
