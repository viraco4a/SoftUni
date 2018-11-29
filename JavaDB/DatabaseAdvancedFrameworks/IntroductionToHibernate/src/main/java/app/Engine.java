package app;

import app.entities.Address;
import app.entities.Employee;
import app.entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    private void test(){
        Scanner scanner = new Scanner(System.in);
        String employeeName = scanner.nextLine();

        entityManager.getTransaction().begin();
        try {
            Employee employee = this.entityManager
                    .createQuery("FROM Employees WHERE CONCAT(first_name, ' ', last_name) = :name",
                            Employee.class)
                    .setParameter("name", employeeName)
                    .getSingleResult();
            System.out.println("Yes");
        } catch (NoResultException e) {
            System.out.println("No");
        }

        this.entityManager.getTransaction().commit();

    }

    /**
     * Problem 6. Adding a New Address and Updating Employee
     */
    private void addingNewAddressAndUpdatingEmployee(){
        Scanner scanner = new Scanner(System.in);
        String lastName = scanner.nextLine();

        this.entityManager.getTransaction().begin();

        Address address = new Address();
        address.setText("Vitoshka 15");

        Town town = this.entityManager
                .createQuery("FROM Town WHERE name = 'Sofia'",
                        Town.class)
                .getSingleResult();
        address.setTown(town);
        this.entityManager.persist(address);

        Employee employee = this.entityManager
                .createQuery("FROM Employee WHERE last_name = :name",
                        Employee.class)
                .setParameter("name", lastName)
                .getSingleResult();

        this.entityManager.detach(employee.getAddress());
        employee.setAddress(address);
        this.entityManager.merge(employee);

        this.entityManager.getTransaction().commit();
    }


}
