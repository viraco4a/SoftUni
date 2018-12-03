package entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "students")
@DiscriminatorValue("st")
public class Student extends Person {
    private int grade;

    public Student(){
        super();
    }

    public Student(String name, int grade) {
        super(name);
        setGrade(grade);
    }

    @Column(
            name = "grade")
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
