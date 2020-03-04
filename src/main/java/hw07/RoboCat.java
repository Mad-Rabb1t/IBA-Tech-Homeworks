package hw07;

public class RoboCat extends Pet {

    public RoboCat(String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
        super.species = Enum.species.Robocat;
    }

    @Override
    public void respond() {
        System.out.printf("Hi, I'm your personal robot-cat, call me %s\n", nickname);
    }
}
