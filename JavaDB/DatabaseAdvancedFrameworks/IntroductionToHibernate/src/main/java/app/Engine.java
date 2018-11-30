package app;

import app.entities.Address;
import app.entities.Employee;
import app.entities.Project;
import app.entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {
    private final EntityManager entityManager;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void run() {
        this.containsEmployee();
    }

    /**
     * Problem 2. Remove Objects
     */
    private void removeObjects(){
        this.entityManager.getTransaction().begin();

        try {
            List<Town> towns = this.entityManager
                    .createQuery("FROM Town", Town.class)
                    .getResultList();

            for (Town town : towns) {
                if (town.getName().length() > 5){
                    this.entityManager.detach(town);
                }
            }

            for (Town town : towns) {
                if (this.entityManager.contains(town)){
                    System.out.print(town.getName() + " -> ");

                    town.setName(town.getName().toLowerCase());

                    System.out.println(town.getName());
                }
            }

            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    /**
     * Problem 3. Contains Employee
     */
    private void containsEmployee(){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        try {
            Employee employee = this.entityManager
                    .createQuery("FROM Employee WHERE concat(first_name, ' ', last_name) = :name",
                            Employee.class)
                    .setParameter("name", name)
                    .getSingleResult();
            System.out.println("yes");
        } catch (NoResultException ex){
            System.out.println("no");
        }

        this.entityManager.getTransaction().commit();
    }

    /**
     * Problem 4. Employees with Salary Over 50 000
     */
    private void employeesWithSalaryOver50k(){
        this.entityManager.getTransaction().begin();
        try {
            List<Employee> employees = this.entityManager
                    .createQuery("FROM employees WHERE salary = 50000",
                            Employee.class)
                    .getResultList();
            for (Employee employee : employees) {
                System.out.println(employee.getFirstName());
            }
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    /**
     * Problem 5. Employees from Department
     */
    private void employeesFromDepartment(){
        this.entityManager.getTransaction().begin();

        try {
            this.entityManager
                    .createQuery("FROM employees AS e WHERE e.deparment = 'Research and Development' ORDER BY e.salary, e.id",
                            Employee.class)
                    .getResultList()
                    .forEach(e -> System.out.printf("%s %s from %s - $%.2f%n",
                            e.getFirstName(),
                            e.getLastName(),
                            e.getDepartment().getName(),
                            e.getSalary()
                            ));
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    /**
     * Problem 6. Adding a New Address and Updating Employee
     */
    private void addingNewAddressAndUpdatingEmployee(){
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        try {
            Address address = new Address();
            address.setText("Vitoshka 10");

            Town town = this.entityManager
                    .createQuery("FROM Towns WHERE name = 'Sofia'",
                            Town.class)
                    .getSingleResult();
            address.setTown(town);
            this.entityManager.persist(address);

            Employee employee = this.entityManager
                    .createQuery("FROM Employees WHERE last_name = :name",
                            Employee.class)
                    .setParameter("name", lastName)
                    .getSingleResult();

            this.entityManager.detach(employee.getAddress());
            employee.setAddress(address);
            this.entityManager.merge(employee);

            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    /**
     * Problem 7. Addresses with Employee Count
     */
    private void addressesWithEmployeeCount(){
        this.entityManager.getTransaction().begin();

        try {
            StringBuilder sb = new StringBuilder();
            this.entityManager
                    .createQuery("FROM addresses AS a ORDER BY a.employees.size DESC, a.town_id",
                            Address.class)
                    .setMaxResults(10)
                    .getResultList()
                    .forEach(a -> sb.append(String.format("%s, %s - %d employees%n",
                            a.getText(),
                            a.getTown().getName(),
                            a.getEmployees().size()
                            )
                    ));

            System.out.println(sb.toString().trim());
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    /**
     * Problem 8. Get Employee with Project
     */
    private void getEmployeeWithProject(){
        Scanner scanner = new Scanner(System.in);
        int idSeeked = Integer.parseInt(scanner.nextLine());
        this.entityManager.getTransaction().begin();

        try {
            Employee employee = this.entityManager
                    .createQuery("FROM employees AS e WHERE e.employee_id = :id",
                            Employee.class)
                    .setParameter("id", idSeeked)
                    .getSingleResult();

            StringBuilder sb = new StringBuilder();

            sb.append(employee.getFirstName())
                    .append(" ")
                    .append(employee.getLastName())
                    .append(" - ")
                    .append(employee.getJobTitle())
                    .append(System.lineSeparator());

            employee.getProjects().stream()
                    .sorted(Comparator.comparing(Project::getName))
                    .forEach(project -> sb
                            .append("\t")
                            .append(project.getName())
                            .append(System.lineSeparator())
                    );

            System.out.println(sb.toString().trim());
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    /**
     * Problem 9. Find Latest 10 Projects
     */
    private void findLatest10Projects(){
        this.entityManager.getTransaction().begin();

        StringBuilder sb = new StringBuilder();
        try {
            this.entityManager
                    .createQuery("FROM projects ORDER BY start_date DESC",
                            Project.class)
                    .setMaxResults(10)
                    .getResultList()
                    .stream()
                    .sorted(Comparator.comparing(Project::getName))
                    .forEach(project -> sb
                            .append("Project name: ")
                            .append(project.getName())
                            .append(System.lineSeparator())
                            .append("Project Description: ")
                            .append(project.getDescription())
                            .append(System.lineSeparator())
                            .append("Project Start Date: ")
                            .append(project.getStartDate())
                            .append(System.lineSeparator())
                            .append("Project End Date: ")
                            .append(project.getEndDate())
                            .append(System.lineSeparator())
                    );
            this.entityManager.getTransaction().commit();
            System.out.println(sb.toString().trim());

        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    /**
     * Problem 10. Increase Salaries
     */
    private void increaseSalaries(){
        this.entityManager.getTransaction().begin();
        try {
            this.entityManager
                    .createQuery("FROM employees AS e " +
                            "WHERE e.department.name IN ('Engineering', 'Tool Design', 'Marketing', 'Information Services') " +
                            "ORDER BY e.id", Employee.class)
                    .getResultList()
                    .forEach(employee -> {
                        employee
                                .setSalary(
                                        employee.getSalary()
                                                .multiply(
                                                        BigDecimal.valueOf(1.12)
                                                )
                                );
                        System.out.printf("%s %s (%.2f)%n",
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary()
                                );
                    });

            this.entityManager.getTransaction().commit();


        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }

    }

    /**
     * Problem 11. Remove Towns
     */
    private void removeTowns(){
        Scanner scanner = new Scanner(System.in);
        String townToRemove = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        try {
            Town town = this.entityManager
                    .createQuery("FROM towns AS t WHERE t.name = :name",
                            Town.class)
                    .setParameter("name", townToRemove)
                    .getSingleResult();

            List<Address> addresses = this.entityManager
                    .createQuery("FROM  addresses AS a WHERE a.town.name = :name",
                            Address.class)
                    .setParameter("name", town.getName())
                    .getResultList();

            String result = String.format("%d address%s in %s deleted",
                    addresses.size(),
                    addresses.size() != 1 ? "es" : "",
                    town.getName()
                    );
            System.out.println(result);

            addresses.forEach(address -> {
                for (Employee employee : address.getEmployees()) {
                    employee.setAddress(null);
                }
                address.setTown(null);
                this.entityManager.remove(address);
            });

            this.entityManager.remove(town);

            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            this.entityManager.close();
        }
    }

    /**
     * Problem 12. Find Employees by First Name
     */
    private void findEmployeesByFirstName() {
        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        try {
            this.entityManager
                    .createQuery("FROM employees AS e WHERE e.firstName LIKE :p",
                            Employee.class)
                    .setParameter("p", pattern + "%")
                    .getResultList()
                    .forEach(employee -> {
                        System.out.println(String
                        .format("%s %s - %s - (%.2f)%n",
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getDepartment(),
                                employee.getSalary()
                                ));
                    });

            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }

    }

    /**
     * Problem 13. Employees Maximum Salaries
     */
    private void employeesMaximumSalaries() {
        this.entityManager.getTransaction().begin();
        StringBuilder sb = new StringBuilder();
        try {
            this.entityManager
                    .createQuery("FROM employees AS e " +
                            "WHERE e.salary NOT BETWEEN 30000 AND 70000 " +
                            "GROUP BY e.departments " +
                            "ORDER BY e.salary DESC", Employee.class)
                    .getResultList()
                    .forEach(employee -> sb.append(String.format("%s - %.2f%n",
                            employee.getDepartment().getName(),
                            employee.getSalary()
                            ))
                    );
            System.out.println(sb.toString().trim());
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }
}
