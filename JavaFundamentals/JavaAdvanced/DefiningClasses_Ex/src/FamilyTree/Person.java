package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private static int idCounter = 1;
    private int id;
    private String firstName = "kur";
    private String lastName = "kur";
    private String birthday = "kur";
    private List<Person> parents;
    private List<Person> children;

    public Person() {
        this.id = idCounter++;
        parents = new ArrayList<>();
        children = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void addParent(Person person) {
        this.parents.add(person);
    }

    public void addChld(Person person) {
        this.children.add(person);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s %s %s",
                this.firstName, this.lastName, this.birthday))
        .append(System.lineSeparator());
        sb.append("Parents:").append(System.lineSeparator());
        for (Person parent : this.parents) {
            sb.append(String.format("%s %s %s",
                    parent.firstName, parent.lastName, parent.birthday));
        }
        sb.append("Children:").append(System.lineSeparator());
        for (Person child : this.children) {
            sb.append(String.format("%s %s %s",
                    child.firstName, child.lastName, child.birthday));
        }

        return sb.toString();
    }
}
