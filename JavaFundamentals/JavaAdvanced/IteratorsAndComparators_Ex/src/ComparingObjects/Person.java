package ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person other) {
        if (this.name.equals(other.name)) {
            if (this.age == other.age) {
                return this.town.compareTo(other.town);
            }

            return this.age - other.age;
        }

        return this.name.compareTo(other.name);
    }
}
