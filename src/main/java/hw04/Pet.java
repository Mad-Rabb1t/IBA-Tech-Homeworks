package hw04;

import java.util.Arrays;

public class Pet {
    String species;
    String nickname;
    int age;
    int trickLevel;
    String [] habits;

    public Pet(String species, String nickname){
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, int trickLevel, String[] habits){
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }
    public Pet(){}

   public void eat(){
        System.out.println("I'm eating ");
    }
    public void respond(){
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", nickname);
    }
    public void foul(){
        System.out.println("I need to cover it up.");
    }

    @Override
    public String toString() {
        return species + "{nickname = " +nickname+", age = "+age + ",trickLevel="+trickLevel+",habits = "+ Arrays.toString(habits) + "\n";
    }
}
