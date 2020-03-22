package hw11.Entities;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public final class Woman extends Human {

    public Woman(String name, String surname, String birthDate, int iq, HashMap<String,String> schedule, Family family) {
        super(name, surname,  LocalDateTime.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")), iq, schedule, family);
    }

    public Woman(String name, String surname, String birthDate, int iq, HashMap<String,String> schedule) {
        super(name, surname,  LocalDateTime.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")), iq, schedule);
    }

    public Woman(String name, String surname, Family family) {
        super();
        super.name = name;
        super.surname = surname;
        super.family = family;
    }

    public Woman(String name, String surname) {
        super();
        super.name = name;
        super.surname = surname;
    }

    @Override
    public void greetPet() {
        System.out.println("Hey there, little friend!");
    }

    @Override
    public String toString() {
        return String.format("Woman{name='%s', surname='%s', date of birth = %s, iq=%d}", super.name, super.surname,
                super.birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), super.iq);
    }

    public void makeup() {
        System.out.println("Gonna look gorgeous today :) ");
    }
}
