package spring1.orm.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class FactoryApp {
    private SessionFactory factory;

    @PostConstruct
    public void init() {
        factory = new Configuration()
                .configure("configs/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void shutdown() {
        factory.close();
    }
}
