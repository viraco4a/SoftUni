package entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "visitations")
public class Visitation extends BaseEntity {
    private Date visitationDate;
    private String comments;
    private Patient patient;

    public Visitation() {
    }

    @Column(name = "visitation_date")
    public Date getVisitationDate() {
        return visitationDate;
    }

    public void setVisitationDate(Date visitationDate) {
        this.visitationDate = visitationDate;
    }

    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToOne(
            optional = false,
            targetEntity = Patient.class,
            cascade = CascadeType.ALL
    )
    @JoinColumn(referencedColumnName = "id")
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
