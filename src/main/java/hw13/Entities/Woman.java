package hw13.Entities;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public final class Woman extends Human {

    public Woman(String name, String surname, LocalDate year, int iq, HashMap<String,String> schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public Woman(String name, String surname, LocalDate year, int iq, HashMap<String,String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    public Woman(String name, String surname, String date, int iq){
        super(name, surname, date, iq);
    }

    public Woman(String name, String surname, LocalDate date, Family family) {
        super();
        super.name = name;
        super.surname = surname;
        super.family = family;
        super.birthDate = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime();
    }

    @Override
    public void greetPet() {
        System.out.println("Hey there, little friend!");
    }

    @Override
    public String toString() {
        return String.format("Woman{name='%s', surname='%s', date of birth = %s, iq=%d}", super.name, super.surname,
                Instant.ofEpochMilli(super.birthDate).atZone(ZoneId.systemDefault()).toLocalDate()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), super.iq);
    }

    public void makeup() {
        System.out.println("Gonna look gorgeous today :) ");
    }
}
