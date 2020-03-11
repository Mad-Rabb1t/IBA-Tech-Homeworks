package hw09;


import java.util.HashMap;

public final class Man extends Human {

    public Man(String name, String surname, int year, int iq, HashMap<String,String> schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public Man(String name, String surname, int year, int iq, HashMap<String,String> schedule) {
        super(name, surname, year, iq, schedule);
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
        return String.format("Man{name='%s', surname='%s', year=%d, iq=%d}", super.name, super.surname, super.b_year, super.iq);
    }

    public void repairCar() {
        System.out.println("Replaced some spark plugs: engine runs like hell!");
    }
}
