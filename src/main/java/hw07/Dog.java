package hw07;

public class Dog extends Pet implements Foul {

    public Dog(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.species = Enum.species.Dog;
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
