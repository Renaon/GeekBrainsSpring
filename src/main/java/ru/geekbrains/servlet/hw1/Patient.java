package ru.geekbrains.servlet.hw1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("patient")
@Scope("prototype")
public class Patient {
    private boolean passport = false;
    private boolean insPolicy = false;
    private boolean direction = false;

    private Hospital hospital;

    public boolean validDocs(){
        return passport && insPolicy && direction;
    }

    public Patient(){
        System.out.println("Собираю документы");
        setDirection();
        setPassport();
        setInsPolicy();
        if(validDocs()) System.out.println("Могу отправляться в поликлинику!");
        else System.out.println("Что-то потерялось, надо поискать под кроватью");
    }

    public void setPassport() {
        this.passport = true;
    }

    public void setInsPolicy() {
        this.insPolicy = true;
    }

    public void setDirection() {
        this.direction = true;
    }

    @Autowired
    @Qualifier("hospital")
    public void setHospital(Hospital hospital){
        this.hospital = hospital;
    }

    public void goForADoctor() {
        System.out.println("Обращаюсь в регистратуру");
        hospital.findCard();
        hospital.timetable();
        hospital.docAppoint();
        System.out.println("Теперь можно и домой");
    }
}
