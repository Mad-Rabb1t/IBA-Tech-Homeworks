package hw05;

public class Main {
    public static void main(String[] args) {

        String[] habits = {"eat","sleep","play"};
        //schedule
        String[][] event = new String[7][2];

        event[0][0] = "sunday";
        event[0][1] = "Do the homework";
        event[1][0] = "monday";
        event[1][1] = "Go to courses, watch a film";
        event[2][0] = "tuesday";
        event[2][1] = "Hang out with friends";
        event[3][0] = "wednesday";
        event[3][1] = "Do the workout";
        event[4][0] = "thursday";
        event[4][1] = "Play PS4";
        event[5][0] = "friday";
        event[5][1] = "Go to the cinema";
        event[6][0] = "saturday";
        event[6][1] = "Date a girl";
        //
        Pet pet1 = new Pet("dog", "chop");
        Pet pet2 = new Pet();
        pet1.setHabits(habits);
        pet1.setAge(6);
        pet2.setSpecies("Dog");
        pet2.setNickname("Goofy");
        pet2.setAge(4);
        pet2.setHabits(habits);
        Pet pet3 = new Pet("Cat", "Stinger", 6, 80, habits);


        Human dad1 = new Human();
        Human mom1 = new Human();
        Family fam1 = new Family(dad1,mom1);
        dad1.setName("Michael");
        dad1.setSurname("Townley");
        dad1.setB_year(1965);
        mom1 = new Human("Amanda","Townley",1969,74,event,fam1);
        Human cld1 = new Human("Jimmy", "Townley", 1991, 45,event, fam1);
        fam1.setPet(pet1);

        Human dad2 = new Human();
        Human mom2 = new Human();
        Family fam2 = new Family(dad2,mom2);
        dad2 = new Human("Lester", "Crest", 1969,100, event,fam2);
        mom2 = new Human("Paige", "Harris", 1981, 92, event, fam2);
        Human cld2 = new Human("Olivia", "Crest", 2005, 15, event, fam2);
        fam2.setPet(pet2);

        Human dad3 = new Human();
        Human mom3 = new Human();
        Family fam3 = new Family(dad3,mom3);
        dad3 = new Human("Samuel", "Jackson", 1999, 82, event, fam3);
        mom3 = new Human("Samantha", "Jackson", 2000, 54, event, fam3);
        Human cld3 = new Human("Susan", "Jackson", 2019, 4, event, fam3);
        fam3.setPet(pet3);

        System.out.println(fam1.toString());
        fam1.describePet();
        fam1.greetPet();
        pet1.respond();
        pet1.eat();
        pet1.foul();

        System.out.println(fam2.toString());
        fam2.describePet();
        fam2.greetPet();
        pet2.respond();
        pet2.eat();
        pet2.foul();

        System.out.println(fam3.toString());
        fam3.describePet();
        fam3.greetPet();
        pet3.respond();
        pet3.eat();
        pet3.foul();




    }
}
