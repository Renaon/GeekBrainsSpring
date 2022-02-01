package ru.geekbrains.hw2.servlet;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("product")
@Scope("prototype")
public class Product {
    private int id;
    private String title;
    private double cost;
    private static int counter = 0;

    public Product(String title, double cost) {
        this.id = counter;
        this.title = title;
        this.cost = cost;
        counter++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }
}
