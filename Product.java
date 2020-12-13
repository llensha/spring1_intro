package ru.geekbrains.spring.context;

public class Product {
    private int id;
    private String title;
    private double cost;

    public Product(int id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Product %d %s %.2f", id, title, cost);
    }

}
