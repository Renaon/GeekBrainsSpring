package ru.geekbrains.servlet.hw1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("hospital")
@Scope("prototype")
public class Hospital {

    public void findCard(){
        System.out.println("Карта пациента найдена");
    }

    public void timetable(){
        System.out.println("Выяснили расписание врача");
    }

    public void docAppoint(){
        System.out.println("Можно идти к доктору");
    }

}
