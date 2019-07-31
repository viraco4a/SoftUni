package border_control;

public class Citizen implements Identifiable {
    private String id;
    private String name;
    private int age;

    public Citizen(String name, int age, String id) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
