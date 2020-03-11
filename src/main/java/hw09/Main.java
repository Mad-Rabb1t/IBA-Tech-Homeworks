package hw09;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {


        HashSet<String> habits = new HashSet<>(Arrays.asList("eat", "sleep", "play"));
        //schedule
        HashMap<String, String> event = new HashMap<>();

        event.put(DayOfTheWeek.Sunday.name(), "Do the homework");
        event.put(DayOfTheWeek.Monday.name(), "Go to courses, watch a film");
        event.put(DayOfTheWeek.Tuesday.name(), "Hang out with friends");
        event.put(DayOfTheWeek.Wednesday.name(), "Do the workout");
        event.put(DayOfTheWeek.Thursday.name(), "Play PS4");
        event.put(DayOfTheWeek.Friday.name(), "Go to the cinema");
        event.put(DayOfTheWeek.Saturday.name(), "Date a girl");
        //
        Pet pet1 = new Dog("Chop", 5, 75, habits);
        Pet pet2 = new RoboCat("Goofy", 4, 100, new HashSet<>(Arrays.asList("Turn on/off", "Charge", "Stand-by")));
        Pet pet3 = new DomesticCat("Stinger", 3, 45, habits);
        Pet pet4 = new Fish("Nemo", 1, 10, new HashSet<>(Arrays.asList("Stare", "Eat", "Forget")));


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

        FamilyController controller = new FamilyController();
        System.out.println(controller.bornChild(fam3, "Girl", "Sofia"));
        System.out.println();
        System.out.println(controller.getAllFamilies());
        System.out.println();
        controller.createNewFamily(new Man("James", "Browning"), new Woman("Natalie", "Browning"));
        controller.displayAllFamilies();
        System.out.println();
        System.out.println(controller.getFamiliesBiggerThan(2));
        System.out.println();
        System.out.println(controller.getFamiliesLessThan(4));
        System.out.println();
        System.out.println(controller.countFamiliesWithMemberNumber(2));
        System.out.println();
        System.out.println(controller.deleteFamilyByIndex(1));
        System.out.println();
        System.out.println(controller.adoptChild(fam1, new Man("Jerry", "Armstrong")));
        System.out.println();
        controller.deleteAllChildrenOlderThan(18);
        System.out.println(controller.count());
        System.out.println();
        System.out.println(controller.getFamilyById(0));
        System.out.println();
        controller.addPet(0, pet4);
        System.out.println(controller.getPets(0));
        System.out.println();


    }
}

