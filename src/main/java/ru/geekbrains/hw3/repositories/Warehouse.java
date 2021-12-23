package ru.geekbrains.hw3.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.hw3.entites.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class Warehouse {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(String title, int price){
        products.add(new Product(title, price));
    }

    public Product findById(int id){
        return products.get(id);
    }

}
