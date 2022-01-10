package ru.geekbrains.hw3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.hw3.entites.Product;
import ru.geekbrains.hw3.service.WarehouseService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WarehouseController {
    private WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }


    @RequestMapping("/store")
    public String store(Model model){
        List<Product> warehouseList = warehouseService.getWarehouse();
        model.addAttribute("store", warehouseList);
        return "store";
    }
}
