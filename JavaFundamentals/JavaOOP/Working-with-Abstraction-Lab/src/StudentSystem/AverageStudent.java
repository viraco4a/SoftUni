package StudentSystem;

public class AverageStudent extends Student {
    public AverageStudent(String name, int age, double grade) {
        super(name, age, grade);
    }

    @Override
    public String toString() {
        return super.toString() + " Average student.";
    }
}
