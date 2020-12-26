package spring1.orm.hibernate;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class ClientDao {

    private FactoryApp factory;

    public ClientDao(FactoryApp factory) {
        this.factory = factory;
    }

    public Client findById(Long id) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.getTransaction().commit();
            return client;
        }
    }

    public List<Client> findAll() {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Client> clients = session.createQuery("from Client").getResultList();
            session.getTransaction().commit();
            return clients;
        }
    }

    public Client saveOrUpdate(Client client) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(client);
            session.getTransaction().commit();
            return client;
        }
    }

    public void deleteById(Long id) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Client client = session.get(Client.class, id);
            session.delete(client);
            session.getTransaction().commit();
        }
    }
}
