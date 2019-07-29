package StudentSystem;

public class ExcellentStudent extends Student {

    public ExcellentStudent(String name, int age, double grade) {
        super(name, age, grade);
    }

    @Override
    public String toString() {
        return super.toString() + " Excellent student.";
    }
}
