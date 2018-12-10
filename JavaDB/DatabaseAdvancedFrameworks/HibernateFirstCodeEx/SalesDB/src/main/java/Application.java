import entities.Customer;
import entities.Product;
import entities.Sale;
import entities.StoreLocation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setEmail("pesho@abv.bg");
        customer.setName("Pesho Peshev");
        customer.setCreditCardNumber("ABCD123456");

        StoreLocation storeLocation = new StoreLocation();
        storeLocation.setLocationName("The Mall");

        Product product = new Product();
        product.setName("Dolnitza");
        product.setPrice(BigDecimal.valueOf(9.99));
        product.setQuantity(1d);

        Sale sale = new Sale();
        sale.setCustomer(customer);
        sale.setProduct(product);
        sale.setStoreLocation(storeLocation);

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("sales");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(customer);
            entityManager.persist(product);
            entityManager.persist(storeLocation);
            entityManager.persist(sale);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
