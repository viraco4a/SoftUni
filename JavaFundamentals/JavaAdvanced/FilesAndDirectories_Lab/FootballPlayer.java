import java.io.Serializable;

public class FootballPlayer implements Serializable {
    private String name;
    private int age;
    private String team;
    private double salary;

    public FootballPlayer(String name, int age, String team, double salary) {
        this.name = name;
        this.age = age;
        this.team = team;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.team + " " + this.salary;
    }
}
