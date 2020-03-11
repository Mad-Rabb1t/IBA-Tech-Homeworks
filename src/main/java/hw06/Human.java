package hw06;

import java.util.Arrays;
import java.util.Objects;

public class Human {
    private String name;
    private String surname;
    private int b_year;
    private int iq;
    private String[][] schedule;
    private Family family;

    public Human(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        this.name = name;
        this.surname = surname;
        b_year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
    }

    public Human(String name, String surname, int year, int iq, String[][] schedule) {
        this.name = name;
        this.surname = surname;
        b_year = year;
        this.iq = iq;
        this.schedule = schedule;
    }

    public Human() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Family getFamily() {
        return family;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setB_year(int b_year) {
        this.b_year = b_year;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, iq=%d, schedule=%s}", name, surname, b_year, iq, Arrays.toString(schedule));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return b_year == human.b_year &&
                name.equals(human.name) &&
                surname.equals(human.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, b_year);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Human has been deleted...");
        super.finalize();
    }
}
