package hw07;

public class DomesticCat extends Pet implements Foul {

    @Override
    public void foul() {
        System.out.println("I need to cover it up...");
    }
    @Override
    public void respond(){
        System.out.printf("Myau, I'm a cat, my name is %s\n", nickname);
    }

    public DomesticCat(String nickname, int age, int trickLevel, String[] habits){
        super(nickname, age, trickLevel, habits);
        super.species = species.DomesticCat;
    }
}
