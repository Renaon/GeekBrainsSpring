package ru.geekbrains.hw3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.hw3.entites.Product;
import ru.geekbrains.hw3.service.DbHandler;

@Controller
@RequestMapping("/product")
public class StoreController {
    private final DbHandler dbHandler = new DbHandler();

    @GetMapping("/add")
    public String add(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "form";
    }

    @PostMapping("/add")
    public String pcessAddres(@ModelAttribute("product") Product product, Model model){
        dbHandler.addProduct(product);
        return "success";
    }

    @GetMapping("/store")
    public String store(Model model){
        Product[] products = dbHandler.getProducts();
        model.addAttribute("products", products);
        return "store";
    }
}
