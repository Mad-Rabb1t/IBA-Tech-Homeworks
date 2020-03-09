package hw07;

public class Main {

    public static void main(String[] args) {

        String[] habits = {"eat", "sleep", "play"};
        //schedule
        String[][] event = new String[7][2];

        event[0][0] = DayOfTheWeek.Sunday.name();
        event[0][1] = "Do the homework";
        event[1][0] = DayOfTheWeek.Monday.name();
        event[1][1] = "Go to courses, watch a film";
        event[2][0] = DayOfTheWeek.Tuesday.name();
        event[2][1] = "Hang out with friends";
        event[3][0] = DayOfTheWeek.Wednesday.name();
        event[3][1] = "Do the workout";
        event[4][0] = DayOfTheWeek.Thursday.name();
        event[4][1] = "Play PS4";
        event[5][0] = DayOfTheWeek.Friday.name();
        event[5][1] = "Go to the cinema";
        event[6][0] = DayOfTheWeek.Saturday.name();
        event[6][1] = "Date a girl";
        //
        Pet pet1 = new Dog("Chop", 5, 75, habits);
        Pet pet2 = new RoboCat("Goofy", 4, 100, new String[]{"Turn on/off", "Charge", "Stand-by"});
        Pet pet3 = new DomesticCat("Stinger", 3, 45, habits);
        Pet pet4 = new Fish("Nemo", 1, 10, new String[]{"Stare", "Eat", "Forget"});


        Human dad1 = new Man("Michael", "Townley", 1965, 83, event);
        Human mom1 = new Woman("Amanda", "Townley", 1969, 74, event);
        Family fam1 = new Family(dad1, mom1, pet1);
        Man cld1 = new Man("Jimmy", "Townley", 1991, 45, event, fam1);
        fam1.addChild(cld1);

        Human dad2 = new Man("Lester", "Crest", 1969, 100, event);
        Human mom2 = new Woman("Paige", "Harris", 1981, 92, event);
        Family fam2 = new Family(dad2, mom2, pet2);
        Human cld2 = new Woman("Olivia", "Crest", 2005, 15, event);
        fam2.addChild(cld2);

        Human dad3 = new Man("Samuel", "Jackson", 1999, 82, event);
        Human mom3 = new Woman("Samantha", "Jackson", 2000, 54, event);
        Family fam3 = new Family(dad3, mom3, pet3);
        Woman cld3 = new Woman("Susan", "Jackson", 2019, 4, event);
        fam3.addChild(cld3);
        fam3.addChild(cld1);
        fam3.deleteChild(cld1);
        fam3.deleteChild(-1);

        System.out.println(fam1.toString());
        System.out.printf("Our family consists of %d members\n", fam1.countFamily());
        cld1.repairCar();
        fam1.describePet();
        cld1.greetPet();
        pet1.respond();
        pet1.eat();
        pet1.foul();

        System.out.println(fam2.toString());
        System.out.printf("Our family consists of %d members\n", fam2.countFamily());
        fam2.describePet();
        cld2.greetPet();
        pet2.respond();
        pet2.eat();
        pet2.foul();

        System.out.println(fam3.toString());
        System.out.printf("Our family consists of %d members\n", fam3.countFamily());
        cld3.makeup();
        fam3.describePet();
        cld3.greetPet();
        pet3.respond();
        pet3.eat();
        pet3.foul();
    }
}

