package hw04;

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
        pet1.habits = habits;
        pet1.age = 6;
        pet2.species = "Dog";
        pet2.nickname = "Goofy";
        pet2.age = 4;
        pet2.habits = habits;
        Pet pet3 = new Pet("Cat", "Stinger", 6, 80, habits);

        Human dad1 = new Human();
        dad1.name = "Michael";
        dad1.surname = "Townley";
        dad1.b_year = 1965;
        Human mom1 = new Human("Amanda","Townley",1969);
        Human cld1 = new Human("Jimmy", "Townley", 1991, 80, pet1, mom1, dad1 , event);

        Human dad2 = new Human("Lester", "Crest", 1969);
        Human mom2 = new Human("Paige", "Harris", 1981);
        Human cld2 = new Human("Olivia", "Crest", 2005, mom2, dad2);
        cld2.pet = pet2;

        Human dad3 = new Human("Samuel", "Jackson", 1999);
        Human mom3 = new Human("Samantha", "Jackson", 2000);
        Human cld3 = new Human("Susan", "Jackson", 2019, mom3, dad3);
        cld3.pet = pet3;


        System.out.println(cld1.toString());
        cld1.describePet();
        cld1.greetPet();
        pet1.respond();
        pet1.eat();
        pet1.foul();

        System.out.println(cld2.toString());
        cld2.describePet();
        cld2.greetPet();
        pet2.respond();
        pet2.eat();
        pet2.foul();

        System.out.println(cld3.toString());
        cld3.describePet();
        cld3.greetPet();
        pet3.respond();
        pet3.eat();
        pet3.foul();




    }
}
