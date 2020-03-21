package hw09.Entities;



import hw09.Entities.Species;

import java.util.HashSet;

public abstract class Pet {

    protected Species species;
    protected String nickname;
    protected int age;
    protected int trickLevel;
    protected HashSet<String> habits;

    public Pet(String nickname, int age, int trickLevel,  HashSet<String> habits) {
        this.species = Species.Unknown;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() {
    }

    public Species getSpecies() {
        return this.species;
    }

    public String getNickname() {
        return this.nickname;
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

    public void setHabits(HashSet<String> habits) {
        this.habits = habits;
    }

    public HashSet<String> getHabits() {
        return habits;
    }

    public void eat() {
        System.out.println("I'm eating ");
    }

    public abstract void respond();

    public void foul() {
        System.out.println("I need to cover it up.");
    }

    @Override
    public String toString() {
        return species + "{nickname = " + nickname + ", age = " + age + ",trickLevel=" + trickLevel + ",habits = " + habits + "\n";
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Pet has been deleted...");
        super.finalize();
    }
}


