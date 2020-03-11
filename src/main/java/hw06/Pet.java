package hw06;

import java.util.Arrays;

public class Pet {


    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    public Species getSpecies() {
        return this.species;
    }

    public Pet(Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() {
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public String[] getHabits() {
        return habits;
    }

    public void eat() {
        System.out.println("I'm eating ");
    }

    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", nickname);
    }

    public void foul() {
        System.out.println("I need to cover it up.");
    }

    @Override
    public String toString() {
        return species + "{nickname = " + nickname + ", age = " + age + ",trickLevel=" + trickLevel + ",habits = " + Arrays.toString(habits) + "\n";
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Pet has been deleted...");
        super.finalize();
    }
}
