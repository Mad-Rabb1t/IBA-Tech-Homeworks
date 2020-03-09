package hw08;


import java.util.HashMap;

public final class Woman extends Human {

    public Woman(String name, String surname, int year, int iq, HashMap<String,String> schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public Woman(String name, String surname, int year, int iq, HashMap<String,String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    @Override
    public void greetPet() {
        System.out.println("Hey there, little friend!");
    }

    @Override
    public String toString() {
        return String.format("Woman{name='%s', surname='%s', year=%d, iq=%d}", super.name, super.surname, super.b_year, super.iq);
    }

    public void makeup() {
        System.out.println("Gonna look gorgeous today :) ");
    }
}
