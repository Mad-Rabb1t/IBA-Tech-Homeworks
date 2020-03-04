package hw07;

public class Fish extends Pet {

    public Fish(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.species = Enum.species.Fish;
    }

    @Override
    public void respond() {
        System.out.println("Hi, owner. I'm a fish and looks like I forgot my name :(");
    }
}
