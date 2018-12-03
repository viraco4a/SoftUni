package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "teachers")
@DiscriminatorValue("te")
public class Teacher extends Person {
    private String speciality;

    public Teacher(){

    }
    public Teacher(String name, String speciality) {
        super(name);
        setSpeciality(speciality);
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
