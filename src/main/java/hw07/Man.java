package hw07;


public final class Man extends Human {

    public Man(String name, String surname, int year, int iq, String[][] schedule, Family family) {
        super(name, surname, year, iq, schedule, family);
    }

    public Man(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
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
