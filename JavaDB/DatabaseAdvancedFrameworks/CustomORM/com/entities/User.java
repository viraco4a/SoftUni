package com.entities;

import com.db.annotations.Column;
import com.db.annotations.Entity;
import com.db.annotations.PrimaryKey;

@Entity(name = "students")
public class User {
    @PrimaryKey(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "kur")
    private String kur;

    public User() {

    }

    public User(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getKur() {
        return kur;
    }

    public void setKur(String kur) {
        this.kur = kur;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("%d | %s | %s",
                getId(), getFirstName(), getLastName());
    }
}
