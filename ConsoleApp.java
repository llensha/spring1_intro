package ru.geekbrains.spring.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigApp.class);
        Cart cart = context.getBean("cart", Cart.class);
        while (true) {
            System.out.println("Enter command 'add' or 'remove': ");
            String command = scanner.nextLine();
            System.out.println("Enter id: ");
            int id = scanner.nextInt();
            String enter = scanner.nextLine();
            if (command.equals("add")) {
                cart.add(id);
                System.out.println(cart.getCart());
            } else if (command.equals("remove")) {
                cart.remove(id);
                System.out.println(cart.getCart());
            } else {
                System.out.println("Unknown command");
            }
        }

    }
}
