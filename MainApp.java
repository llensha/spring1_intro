package spring1.orm.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        FactoryApp factory = context.getBean("factoryApp", FactoryApp.class);
        ProductDao productDao = context.getBean("productDao", ProductDao.class);
        ClientDao clientDao = context.getBean("clientDao", ClientDao.class);
        ServiceApp service = context.getBean("serviceApp", ServiceApp.class);

        System.out.println(clientDao.findById(3L).getName() + " купил:");
        System.out.println(service.getProductsForClient(3L));

        System.out.println(productDao.findById(4L).getTitle() + " купили:");
        System.out.println(service.getClientsForProduct(9L));

        factory.shutdown();
        context.close();
    }
}
