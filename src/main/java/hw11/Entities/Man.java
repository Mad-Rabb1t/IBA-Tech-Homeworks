package hw11.Entities;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public final class Man extends Human {

    public Man(String name, String surname, String birthDate, int iq, HashMap<String,String> schedule, Family family) {
        super(name, surname, LocalDateTime.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")), iq, schedule, family);
    }

    public Man(String name, String surname, String birthDate, int iq, HashMap<String,String> schedule) {
        super(name, surname,  LocalDateTime.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")), iq, schedule);
    }

    public Man(String name, String surname, Family family) {
        super();
        super.name = name;
        super.surname = surname;
        super.family = family;
    }

    public Man(String name, String surname) {
        super();
        super.name = name;
        super.surname = surname;
    }

    @Override
    public void greetPet() {
        System.out.println("Hey, whats up buddy!");
    }

    @Override
    public String toString() {
        return String.format("Man{name='%s', surname='%s', date of birth = %s, iq=%d}", super.name, super.surname,
                super.birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), super.iq);
    }

    public void repairCar() {
        System.out.println("Replaced some spark plugs: engine runs like hell!");
    }
}
