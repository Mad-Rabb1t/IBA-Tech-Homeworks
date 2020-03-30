package hw13.Entities;

import java.util.HashSet;

public class DomesticCat extends Pet implements Foul {

    public DomesticCat(String nickname, int age, int trickLevel, HashSet<String> habits) {
        super(nickname, age, trickLevel, habits);
        super.species = Species.DomesticCat;
    }

    @Override
    public void foul() {
        System.out.println("I need to cover it up...");
    }

    @Override
    public void respond() {
        System.out.printf("Myau, I'm a cat, my name is %s\n", nickname);
    }
}
