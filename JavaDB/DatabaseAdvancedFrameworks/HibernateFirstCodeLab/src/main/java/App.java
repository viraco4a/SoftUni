import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("soft_uni");

        EntityManager entityManager = factory.createEntityManager();

        Project project = entityManager.find(Project.class, 33);

        Employee employee = project.getEmployees()
                .stream()
                .findAny()
                .orElse(null);

        employee.getProjects()
                .stream()
                .map(Project::getName)
                .forEach(System.out::println);

    }

    static void printProject(Project project){
        project.getEmployees()
                .stream()
                .map(employee -> employee.getName())
                .forEach(System.out::println);
    }

    static void createManyToManyProject(EntityManager entityManager){
        List<Employee> employees = List.of(
                new Employee("Pesho1", new Date()),
                new Employee("Pesho2", new Date()),
                new Employee("Pesho3", new Date()),
                new Employee("Pesho4", new Date()),
                new Employee("Pesho5", new Date())
        );

        Project project = new Project("Vse taia");

        project.setEmployees(new HashSet<>(employees));

        inTransaction(
                entityManager,
                () -> entityManager.persist(project)
        );
    }

    static void getDeptData(EntityManager entityManager){
        Department department = entityManager.find(Department.class, 32);

        department.getEmployees()
                .forEach(System.out::println);
    }

    static void getEmplData(EntityManager entityManager){
        Employee employee = entityManager.find(Employee.class, 31);
        System.out.println(employee.getName());
        System.out.println(employee.getDepartment().getName());
    }

    static void createEmplDep(EntityManager entityManager){
        Department department = new Department("Engineering");

        Employee employee = new Employee("Pehso", new Date());
        employee.setDepartment(department);

        inTransaction(
                entityManager,
                () -> entityManager.persist(employee)
        );
    }

    static void addStaff(EntityManager entityManager){
        Person[] people = {
                new Student("Pesho" + Math.random(), 3),
                new Teacher("Gosho" + Math.random(), "Java")
        };

        inTransaction(
                entityManager,
                () ->  Arrays.stream(people)
                        .forEach(entityManager::persist)
        );

        Mother mother = new Mother("Gina" + Math.random());
        mother.setChild(people[1]);

        inTransaction(
                entityManager,
                () -> entityManager.persist(mother)
        );

        Mother mother1 = entityManager.find(Mother.class, 5);

        Person person = mother1.getChild();
        Mother mother2 = person.getMother();
        System.out.println(mother1.getName());
        System.out.println(mother1.getChild().getName());
        System.out.println(mother2.getName());
    }

    static void inTransaction(EntityManager entityManager,
                              Runnable runnable){
        entityManager.getTransaction().begin();
        runnable.run();
        entityManager.getTransaction().commit();
    }

    static void createBuilder(EntityManager entityManager){
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Teacher> criteriaQuery = builder.createQuery(Teacher.class);
        criteriaQuery.from(Teacher.class);
        entityManager.createQuery(criteriaQuery)
                .getResultList()
                .forEach(System.out::println);
    }
}
