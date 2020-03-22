package hw11.Entities;

import java.util.HashSet;

public class Dog extends Pet implements Foul {

    public Dog(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname, age, trickLevel, habits);
        super.species = Species.Dog;
    }

    @Override
    public void foul() {
        System.out.println("I need to cover it up...");
    }

    @Override
    public void respond() {
        System.out.printf("Hi owner. I'm %s, the dog, and I miss you!\n", nickname);
    }

}
