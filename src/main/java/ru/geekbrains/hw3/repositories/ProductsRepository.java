package ru.geekbrains.hw3.repositories;

import ru.geekbrains.hw3.entites.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsRepository {
    List<Product> productsRepository = new ArrayList<Product>();

    public List<Product> getProductsRepository() {
        return productsRepository;
    }

    public Product get(int id){
        return productsRepository.get(id);
    }

    public String getTitleById(int id){
        return productsRepository.get(id).getTitle();
    }

    public int getPriceById(int id){
        return productsRepository.get(id).getPrice();
    }

    public void save(Product product) {
        productsRepository.add(product);
    }
    public int size(){
        return productsRepository.size();
    }
}
