package hiberspring.repository;

import hiberspring.domain.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("" +
            "SELECT e " +
            "FROM hiberspring.domain.entities.Employee e " +
            "JOIN e.branch b " +
            "GROUP BY b " +
            "HAVING size(b.products) > 0 " +
            "ORDER BY concat(e.firstName, ' ', e.lastName), length(e.position) DESC "
    )
    List<Employee> exportEmployees();
}
