package com.zlatkov.demo.repositories;

import com.zlatkov.demo.entities.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.EnumMap;

@Repository
public interface EmployeesCrudRepository extends CrudRepository<Employee, Long> {
    Iterable<EnumMap> findAllByFirstNameStartingWith(String prefix);
}
