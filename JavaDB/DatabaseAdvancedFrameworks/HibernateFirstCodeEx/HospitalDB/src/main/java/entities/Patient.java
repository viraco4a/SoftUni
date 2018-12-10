package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "patients")
public class Patient extends BaseEntity {
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private Date dateOfBirth;
    private boolean hasMedicalInsurance;
    private Set<Visitation> visitations;
    private Set<Diagnose> diagnoses;
    private Set<Medicament> prescriptions;

    public Patient() {
    }

    @Column(name = "first_name", nullable = false, length = 30)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false, length = 30)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "address", nullable = false, length = 120)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "email", nullable = false, unique = true, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "date_of_birth")
    @Basic
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Column(name = "has_medical_insurance")
    public boolean isHasMedicalInsurance() {
        return hasMedicalInsurance;
    }

    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }

    @OneToMany(
            targetEntity = Visitation.class,
            mappedBy = "patient",
            cascade = CascadeType.ALL
    )
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "patients_diagnoses",
            joinColumns = @JoinColumn(
                    name = "patient_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "diagnose_id",
                    referencedColumnName = "id")
    )
    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "patients_medicaments",
            joinColumns = @JoinColumn(
                    name = "patient_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "medicament_id",
                    referencedColumnName = "id")
    )
    public Set<Medicament> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<Medicament> prescriptions) {
        this.prescriptions = prescriptions;
    }
}
