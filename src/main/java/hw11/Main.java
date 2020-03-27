package hw11;

import hw11.Controller.FamilyController;
import hw11.Entities.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
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

        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Human dad1 = new Man("Michael", "Townley", LocalDate.parse("30/10/1965",form), 83, event);
        Human mom1 = new Woman("Amanda", "Townley", LocalDate.parse("11/12/1969",form), 74, event);
        Family fam1 = new Family(dad1, mom1, new HashSet<>(Arrays.asList(pet1, pet4)));
        Man cld1 = new Man("Jimmy", "Townley", LocalDate.parse("20/02/1991",form), 45, event, fam1);
        fam1.addChild(cld1);

        Human dad2 = new Man("Lester", "Crest", LocalDate.parse("05/03/1969",form), 100, event);
        Human mom2 = new Woman("Paige", "Harris", LocalDate.parse("12/06/1981",form), 92, event);
        Family fam2 = new Family(dad2, mom2, new HashSet<>(Collections.singletonList(pet2)));
        Human cld2 = new Woman("Olivia", "Crest", LocalDate.parse("12/11/2005",form), 15, event);
        fam2.addChild(cld2);

        Human dad3 = new Man("Samuel", "Jackson", LocalDate.parse("10/10/1999", form), 82, event);
        Human mom3 = new Woman("Samantha", "Jackson", LocalDate.parse("20/04/2000",form), 54, event);
        Family fam3 = new Family(dad3, mom3, new HashSet<>(Collections.singletonList(pet3)));
        Woman cld3 = new Woman("Susan", "Jackson", LocalDate.parse("05/04/2019",form), 4, event);
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

        controller.bornChild(fam3, "Sam", "Sofia");
        controller.createNewFamily(new Man("James", "Browning", "12/04/1991", 81),
                new Woman("Natalie", "Browning", "14/12/1995", 70));

        System.out.println(cld3.describeAge());
        controller.deleteFamilyByIndex(1);
        controller.adoptChild(fam1, new Man("Jerry", "Armstrong", "13/10/2012", 20));
        controller.deleteAllChildrenOlderThan(18);
        controller.displayAllFamilies();
    }
}

