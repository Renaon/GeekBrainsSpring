package ru.geekbrains.hw3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.hw3.entites.Product;
import ru.geekbrains.hw3.repositories.Warehouse;

import java.util.List;

@Service
public class WarehouseService {
    private Warehouse warehouse;

    @Autowired
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Product getProduct(int id) {
        return warehouse.findById(id);
    }

    public List<Product> getWarehouse() {
        return warehouse.getProducts();
    }

    public WarehouseService() {

    }
}
