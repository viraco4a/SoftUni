package entities;

import javax.persistence.*;

@Entity (name = "people")
@DiscriminatorColumn(name = "pt")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {
    private  int id;
    private String name;
    private int age;
    private Mother mother;

    public Person() {

    }

    public Person(String name) {
        setName(name);
    }

    @OneToOne(mappedBy = "child", targetEntity = Mother.class)
    @JoinColumn
    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(
            name = "name",
            length = 50,
            nullable = false,
            unique = true
    )
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
