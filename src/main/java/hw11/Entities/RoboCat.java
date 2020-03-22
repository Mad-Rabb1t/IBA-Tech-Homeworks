package hw11.Entities;

import java.util.HashSet;

public class RoboCat extends Pet {

    public RoboCat(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname, age, trickLevel, habits);
        super.species = Species.Robocat;
    }

    @Override
    public void respond() {
        System.out.printf("Hi, I'm your personal robot-cat, call me %s\n", nickname);
    }

    @Override
    public void foul() {
        System.out.println("I need to cover it up");

    }

}
