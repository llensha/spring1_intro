package spring1.orm.hibernate;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServiceApp {

    private List<Product> products;
    private List<Client> clients;
    private FactoryApp factory;

    public ServiceApp(List<Product> products, List<Client> clients, FactoryApp factory) {
        this.products = products;
        this.clients = clients;
        this.factory = factory;
    }

    public List<Product> getProductsForClient(Long client_id) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT p FROM Product p JOIN FETCH p.clients c WHERE c.id = :id")
                    .setParameter("id", client_id)
                    .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public List<Client> getClientsForProduct(Long product_id) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Client> clients = session.createQuery("SELECT c FROM Client c JOIN FETCH c.products p WHERE p.id = :id")
                    .setParameter("id", product_id)
                    .getResultList();
            session.getTransaction().commit();
            return clients;
        }
    }
}
