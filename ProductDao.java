package spring1.orm.hibernate;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(scopeName = "prototype")
public class ProductDao {

    private FactoryApp factory;

    public ProductDao(FactoryApp factory) {
        this.factory = factory;
    }

    public Product findById(Long id) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public List<Product> findAll() {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public Product saveOrUpdate(Product product) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }

    public void deleteById(Long id) {
        try (Session session = factory.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.delete(session.get(Product.class, id));
            session.getTransaction().commit();
        }
    }

}
