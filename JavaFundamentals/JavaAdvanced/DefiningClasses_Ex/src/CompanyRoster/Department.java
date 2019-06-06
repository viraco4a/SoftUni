package CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;
    private double averageSalary;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public void calculateAverageSalary () {
        int sum = 0;
        for (Employee employee : this.employees) {
            sum += employee.getSalary();
        }
        this.averageSalary = sum / this.employees.size();
    }

    public double getAverageSalary() {
        return this.averageSalary;
    }
}
