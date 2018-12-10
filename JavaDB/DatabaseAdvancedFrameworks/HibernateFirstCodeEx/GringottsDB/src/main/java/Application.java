import entities.WizzardDeposit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Application {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("gingotts");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            WizzardDeposit deposit = new WizzardDeposit();
            deposit.setFirst_name("Pesho");
            deposit.setLast_name("Peshev");
            deposit.setAge(33);
            deposit.setDepositStartDate(new Date());

            entityManager.getTransaction().begin();

            entityManager.persist(deposit);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
