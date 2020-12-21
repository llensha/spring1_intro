import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDao {

    private static SessionFactory factory;

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void shutdown() {
        factory.close();
    }

    public static Product findById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public static List<Product> findAll() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public static Product saveOrUpdate(Product product) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }

    public static void deleteById(Long id) {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public static void main(String[] args) {
        try {
            init();
            System.out.println(findAll());
            System.out.println(findById(2L));
            System.out.println(saveOrUpdate(new Product("Мясо", 90)));
            System.out.println(saveOrUpdate(new Product(3L, "Рыба морская", 55)));
            deleteById(4L);
            System.out.println(findAll());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }
}
