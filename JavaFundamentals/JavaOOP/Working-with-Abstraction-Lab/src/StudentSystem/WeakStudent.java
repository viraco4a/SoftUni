package StudentSystem;

public class WeakStudent extends Student {
    public WeakStudent(String name, int age, double grade) {
        super(name, age, grade);
    }

    @Override
    public String toString() {
        return super.toString() + " Very nice person.";
    }
}
