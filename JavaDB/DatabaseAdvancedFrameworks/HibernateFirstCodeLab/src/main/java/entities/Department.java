package entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "departments")
public class Department {
    private int id;
    private String name;
    Set<Employee> employees;

    public Department() {
    }

    public Department(String name) {
        setName(name);
    }

    @Column
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

    @OneToMany(mappedBy = "department", targetEntity = Employee.class)
    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
