package hw05;

public class Main {
    public static void main(String[] args) {

        String[] habits = {"eat", "sleep", "play"};
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
        Pet pet1 = new Pet("dog", "chop", 6, 62, habits);
        Pet pet2 = new Pet("Dog", "Goofy", 4, 34, habits);
        Pet pet3 = new Pet("Cat", "Stinger", 6, 80, habits);


        Human dad1 = new Human("Michael", "Townley", 1965, 82, event);
        Human mom1 = new Human("Amanda", "Townley", 1969, 74, event);
        Family fam1 = new Family(dad1, mom1, pet1);
        Human cld1 = new Human("Jimmy", "Townley", 1991, 45, event, fam1);

        Human dad2 = new Human("Lester", "Crest", 1969, 100, event);
        Human mom2 = new Human("Paige", "Harris", 1981, 92, event);
        Family fam2 = new Family(dad2, mom2, pet1);
        Human cld2 = new Human("Jane", "Crest", 2000, 68, event, fam2);

        Human dad3 = new Human("Samuel", "Jackson", 1999, 82, event);
        Human mom3 = new Human("Samantha", "Jackson", 2000, 54, event);
        Family fam3 = new Family(dad3, mom3, pet1);
        Human cld3 = new Human("Susan", "Jackson", 2019, 4, event, fam3);


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
