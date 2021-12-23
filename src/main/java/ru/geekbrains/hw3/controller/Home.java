package ru.geekbrains.hw3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class Home {
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    protected void add() {

    }

}
