import entities.Course;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.HashSet;

public class Application {
    public static void main(String[] args) {

        Teacher teacher = new Teacher();
        teacher.setFirstName("Mr.");
        teacher.setLastName("Peters");
        teacher.setEmail("p@gmail.com");
        teacher.setCourses(new HashSet<>());

        Student student = new Student();
        student.setFirstName("Pesho");
        student.setLastName("Peshev");
        student.setCourses(new HashSet<>());

        Course course = new Course();
        course.setName("Java");
        course.setDescription("imba");
        course.setStartDate(new Date());
        course.setTeacher(teacher);
        course.setStudents(new HashSet<>());

        teacher.getCourses().add(course);

        course.getStudents().add(student);

        student.getCourses().add(course);

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("university");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(teacher);
            entityManager.persist(student);
            entityManager.persist(course);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
            factory.close();
        }
    }
}
