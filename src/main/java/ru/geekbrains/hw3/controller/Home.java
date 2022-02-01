package ru.geekbrains.hw3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//$title
//$price

@Controller
@RequestMapping("/home")
public class Home {
    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String hello(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        return "index";
    }

}
