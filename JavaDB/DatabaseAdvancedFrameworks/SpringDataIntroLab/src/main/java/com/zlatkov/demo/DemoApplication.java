package com.zlatkov.demo;

import com.zlatkov.demo.entities.Employee;
import com.zlatkov.demo.repositories.EmployeesCrudRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.EnumMap;

@SpringBootApplication
public class DemoApplication {

    public DemoApplication(EmployeesCrudRepository employeesRepository) {
        Iterable<EnumMap> employees = employeesRepository
                .findAllByFirstNameStartingWith("p");
        for (EnumMap emp : employees) {
            System.out.println(emp);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
