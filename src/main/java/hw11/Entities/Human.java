package hw11.Entities;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Objects;

public class Human {
    protected String name;
    protected String surname;
    protected LocalDateTime birthDate;
    protected int iq;
    protected HashMap<String,String> schedule;
    protected Family family;

    public Human(String name, String surname, LocalDateTime birthDate, int iq, HashMap<String,String> schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
    }

    public Human(String name, String surname, LocalDateTime year, int iq, HashMap<String,String> schedule) {
        this.name = name;
        this.surname = surname;
        birthDate = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human(String name, String surname, String date, int iq){
        this.name = name;
        this.surname = surname;
        birthDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.iq = iq;
    }

    public Human() {
    }

    public void greetPet() {
        family.pets.forEach(pet -> System.out.printf("Hello, %s\n", pet.nickname));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String describeAge(){
        Period age = Period.between(birthDate.toLocalDate(),LocalDate.now());
        return String.format("%s %s is %d years, %d months and %d days old.", name, surname, age.getYears(), age.getMonths(),age.getDays());
    }

    public int getAge(){
        return Period.between(birthDate.toLocalDate(),LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', date of birth = %s, iq=%d, schedule=%s}", name, surname,
                birthDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), iq, schedule);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate &&
                name.equals(human.name) &&
                surname.equals(human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthDate);
    }
}
