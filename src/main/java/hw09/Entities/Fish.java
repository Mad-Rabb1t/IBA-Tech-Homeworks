package hw09.Entities;

import java.util.HashSet;

public class Fish extends Pet {

    public Fish(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname, age, trickLevel, habits);
        super.species = Species.Fish;
    }

    @Override
    public void respond() {
        System.out.println("Hi, owner. I'm a fish and looks like I forgot my name :(");
    }

    @Override
    public void foul() {
        System.out.println("I need to cover it up");
    }
}
