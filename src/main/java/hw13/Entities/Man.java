package hw13.Entities;


import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public final class Man extends Human {

    public Man(String name, String surname, LocalDate year, int iq, HashMap<String,String> schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public Man(String name, String surname, LocalDate year, int iq, HashMap<String,String> schedule) {
        super(name, surname, year, iq, schedule);
    }

    public Man(String name, String surname, String date, int iq){
        super(name, surname, date, iq);
    }

    public Man(String name, String surname, LocalDate date, Family family) {
        super();
        super.name = name;
        super.surname = surname;
        super.family = family;
        super.birthDate =  Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()).getTime();
    }

    @Override
    public void greetPet() {
        System.out.println("Hey, whats up buddy!");
    }

    @Override
    public String toString() {
        return String.format("Man{name='%s', surname='%s', date of birth = %s, iq=%d}", super.name, super.surname,
                Instant.ofEpochMilli(super.birthDate).atZone(ZoneId.systemDefault()).toLocalDate()
                        .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), super.iq);
    }

    public void repairCar() {
        System.out.println("Replaced some spark plugs: engine runs like hell!");
    }
}
