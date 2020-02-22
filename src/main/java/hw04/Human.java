package hw04;

public class Human {
    String name;
    String surname;
    int b_year;
    int iq;
    Pet pet;
    Human mother;
    Human father;
    String[][] schedule;

    public Human(String name, String surname, int year){
        this.name = name;
        this.surname = surname;
        b_year = year;

    }

    public Human(String name, String surname, int year, Human mother, Human father){
        this.name = name;
        this.surname = surname;
        b_year = year;
        this.mother = mother;
        this.father = father;

    }

    public Human(String name, String surname, int year, int iq, Pet pet ,Human mother, Human father, String[][] schedule){
        this.name = name;
        this.surname = surname;
        b_year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;

    }

    public Human(){}

    public void greetPet(){
        System.out.printf("Hello, %s\n", pet.nickname);
    }
    public void describePet(){
        System.out.printf("I have a %s, he is %d years old, he is ",pet.species,pet.age);
        if(pet.trickLevel<50) System.out.println("almost not sly.");
        else System.out.println("very sly");
    }

    @Override
    public String toString() {
        return "Human{name="+ name + ", surname="+ surname + ", year=" +b_year+", iq=" + iq + ", mother=" + mother.name + ", father=" + father.name + ", pet=" + pet + "}\n";
    }

}
