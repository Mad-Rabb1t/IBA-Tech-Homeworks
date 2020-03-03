package hw07;

import java.util.Arrays;

public abstract class Pet {
    public enum species{
        Dog,
        DomesticCat,
        Fish,
        Robocat,
        Unknown
    }
    protected Pet.species species;
    protected String nickname;
    protected int age;
    protected int trickLevel;
    protected String [] habits;

    public String getSpecies() {
        return species.name();
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

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public String[] getHabits() {
        return habits;
    }

    public Pet(String nickname, int age, int trickLevel, String[] habits){
        this.species = species.Unknown;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }
    public Pet(){}

   public void eat(){
        System.out.println("I'm eating ");
    }
    public abstract void respond();
//        System.out.printf("Hello, owner. I am - %s. I miss you!\n", nickname);
//    }

    public void foul(){
        System.out.println("I need to cover it up.");
    }

    @Override
    public String toString() {
        return species + "{nickname = " +nickname+", age = "+age + ",trickLevel="+trickLevel+",habits = "+ Arrays.toString(habits) + "\n";
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Pet has been deleted...");
        super.finalize();
    }
}


