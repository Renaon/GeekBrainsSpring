package ru.geekbrains.hw3.entites;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("product")
@Scope("prototype")
public class Product {
    private int id = 0;
    private String title;
    private int cost;

    public Product(String title, int cost){
        this.id++;
        this.title = title;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }
}
