package hw07;

public class Fish extends Pet{

    @Override
    public void respond() {
        System.out.println("Hi, owner. I'm a fish and looks like I forgot my name :(");
    }

    public Fish(String nickname, int age, int trickLevel, String[] habits){
        super(nickname, age, trickLevel, habits);
        super.species = species.Fish;
    }
}
