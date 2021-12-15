package ru.geekbrains.hw.hw2.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.hw.hw2.Product;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@Component("GET")
@Scope("prototype")
public class GetController {
    Logger LOG = LoggerFactory.getLogger(GetController.class);
    private ArrayList<Product> products = new ArrayList<>();
    HttpServletResponse response;

    public GetController() {
        for (int i = 0; i < 10; i++){
            int cost = 10 + new Random().nextInt(10000-10+1);
            products.add(new Product("Product" + i, cost));
        }
    }

    public void doQuerry(String querry){
        if(querry.equals("ten")) tenProds();
    }

    private void tenProds(){
        try {
            for (Product product : products){
                response.getWriter().println(product.getId() + ". " + product.getTitle() + "    " + product.getCost() + " rub.");
            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }

    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }
}
