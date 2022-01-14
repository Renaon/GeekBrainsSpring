package ru.geekbrains.hw3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.hw3.entites.Product;
import ru.geekbrains.hw3.repositories.ProductsRepository;

@Controller
@RequestMapping("/product")
public class StoreController {
    private ProductsRepository productsRepository = new ProductsRepository();

    @GetMapping("/add")
    public String add(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "form";
    }

    @PostMapping("/add")
    public String pcessAddres(@ModelAttribute("product") Product product, Model model){
        this.productsRepository.save(product);
        return "success";
    }

    @GetMapping("/store")
    public String store(Model model){
        model.addAttribute("productsRepository", productsRepository);
        return "store";
    }
}
