package hw13.Console;

import hw13.Controller.FamilyController;
import hw13.Entities.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Console {
    private void displayMainMenu() {
        System.out.println(
                "=======================================================================================================\n" +
                "                                             MAIN MENU                                                 \n" +
                "=======================================================================================================\n" +
                "- 1. Fill with test data\n" +
                "- 2. Display the entire list of families\n" +
                "- 3. Display a list of families where the number of people is greater than the specified number\n" +
                "- 4. Display a list of families where the number of people is less than the specified number\n" +
                "- 5. Calculate the number of families where the number of members equals to specified \n" +
                "- 6. Create a new family\n" +
                "- 7. Delete a family by its index in the general list\n" +
                "- 8. Edit a family by its index in the general list\n" +
                "- 9. Remove all children over the age of majority\n");
    }

    private void displayEditMenu() {
        System.out.println(
                "    - 1. Give birth to a baby\n" +
                "    - 2. Adopt a child\n" +
                "    - 3. Return to main menu\n"
        );
    }

    public void run(){
        boolean exit = false;
        FamilyController controller = new FamilyController();
        Scanner scan = new Scanner(System.in);
        while (!exit) {
            displayMainMenu();
            String input = scan.nextLine().toLowerCase().trim();
            switch (input) {
                case "1": {
                    HashMap<String, String> event = new HashMap<>();

                    event.put(DayOfTheWeek.Sunday.name(), "Do the housework");
                    event.put(DayOfTheWeek.Tuesday.name(), "Hang out with friends");
                    event.put(DayOfTheWeek.Friday.name(), "Go to the cinema");

                    Pet pet1 = new Dog("Chop", 5, 75,
                            new HashSet<>(Arrays.asList("eat", "sleep", "play")));
                    Pet pet2 = new RoboCat("Goofy", 4, 100,
                            new HashSet<>(Arrays.asList("Turn on/off", "Charge", "Stand-by")));
                    Pet pet3 = new DomesticCat("Stinger", 3, 45,
                            new HashSet<>(Arrays.asList("eat", "sleep", "play")));
                    Pet pet4 = new Fish("Nemo", 1, 10,
                            new HashSet<>(Arrays.asList("Stare", "Eat", "Forget")));

                    DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    Human dad1 = new Man("Michael", "Townley", LocalDate.parse("30/10/1965",form),
                            83, event);
                    Human mom1 = new Woman("Amanda", "Townley", LocalDate.parse("11/12/1969",form),
                            74, event);
                    Family fam1 = new Family(dad1, mom1, new HashSet<>(Arrays.asList(pet1, pet4)));
                    controller.adoptChild(fam1, new Man("Jimmy", "Townley",
                            LocalDate.parse("20/02/1991",form), 45, event, fam1));

                    Human dad2 = new Man("Lester", "Crest", LocalDate.parse("05/03/1969",form),
                            100, event);
                    Human mom2 = new Woman("Paige", "Harris", LocalDate.parse("12/06/1981",form),
                            92, event);
                    Family fam2 = new Family(dad2, mom2, new HashSet<>(Collections.singletonList(pet2)));
                    controller.adoptChild(fam2,new Woman("Olivia", "Crest",
                            LocalDate.parse("12/11/2005",form), 15, event));

                    Human dad3 = new Man("Samuel", "Jackson", LocalDate.parse("10/10/1999", form),
                            82, event);
                    Human mom3 = new Woman("Samantha", "Jackson", LocalDate.parse("20/04/2000",form),
                            54, event);
                    Family fam3 = new Family(dad3, mom3, new HashSet<>(Collections.singletonList(pet3)));
                    controller.adoptChild(fam3, new Woman("Susan", "Jackson",
                            LocalDate.parse("05/04/2019",form), 4, event));
                    System.out.println("Test data created...");
                    break;
                }

                case "2": {
                    if(controller.getAllFamilies().size() == 0)
                        System.out.println("There are no families available");
                    else
                    controller.displayAllFamilies();
                }
                break;

                case "3": {
                    System.out.print("Specify the number: ");
                    int num;
                    while (true){
                        try{
                            num = Integer.parseInt(scan.nextLine());
                            break;
                        } catch (IllegalArgumentException ex){
                            System.out.print("Invalid input! Please enter integer: ");
                        }
                    }
                    ArrayList<Family> famsBigger = controller.getFamiliesBiggerThan(num);
                    if(famsBigger.size() == 0)
                        System.out.println("No families found with such parameters");
                    else controller.getFamiliesBiggerThan(num).forEach(family -> System.out.println(family.prettyFormat()));
                    break;
                }

                case "4": {
                    System.out.print("Specify the number: ");
                    int num;
                    while (true){
                        try{
                            num = Integer.parseInt(scan.nextLine());
                            break;
                        } catch (IllegalArgumentException ex){
                            System.out.print("Invalid input! Please enter integer: ");
                        }
                    }
                    ArrayList<Family> famsLess = controller.getFamiliesLessThan(num);
                    if(famsLess.size() == 0)
                        System.out.println("No families found with such parameters");
                    else famsLess.forEach(family -> System.out.println(family.prettyFormat()));
                    break;
                }

                case "5": {
                    System.out.print("Specify the number: ");
                    int num;
                    while (true){
                        try{
                            num = Integer.parseInt(scan.nextLine());
                            break;
                        } catch (IllegalArgumentException ex){
                            System.out.print("Invalid input! Please enter integer: ");
                        }
                    }
                    System.out.printf("Families with %d members found: %d\n", num,
                            controller.countFamiliesWithMemberNumber(num));
                    break;
                }

                case "6":{
                    // mother init
                    System.out.print("Enter mother's name: ");
                    String m_name = scan.nextLine();
                    System.out.print("Enter mother's surname: ");
                    String m_surname = scan.nextLine();
                    System.out.print("Enter mother's birth year: ");
                    int m_bYear;
                    while (true){
                        try{
                            m_bYear = Integer.parseInt(scan.nextLine());
                            if(m_bYear < 1900 || m_bYear >= 2050) throw new IllegalArgumentException();
                            break;
                        } catch (Exception ex) {
                            System.out.print("Invalid year! Please enter again: ");
                        }
                    }
                    System.out.print("Enter mother's month of birth: ");
                    int m_bMonth;
                    while (true){
                        try{
                            m_bMonth = Integer.parseInt(scan.nextLine());
                            if(m_bMonth > 12 || m_bMonth < 1) throw new IllegalArgumentException();
                            break;
                        } catch (Exception ex) {
                            System.out.print("Invalid month! Please enter again: ");
                        }
                    }
                    System.out.print("Enter mother's birth day: ");
                    int m_bDay;
                    while (true){
                        try{
                            m_bDay = Integer.parseInt(scan.nextLine());
                            LocalDate.parse(String.format("%02d/%02d/%04d", m_bDay,
                                    m_bMonth, m_bYear), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            break;
                        } catch (Exception ex) {
                            System.out.print("Invalid day! Please enter again: ");
                        }
                    }
                    System.out.print("Enter mother's iq: ");
                    int m_iq;
                    while (true){
                        try{
                            m_iq = Integer.parseInt(scan.nextLine());
                            if(m_iq < 0 || m_iq > 100) throw new IllegalArgumentException();
                            break;
                        } catch (Exception ex) {
                            System.out.print("Invalid month! Please enter again: ");
                        }
                    }
                    //
                    //father init
                    System.out.print("Enter father's name: ");
                    String f_name = scan.nextLine();
                    System.out.print("Enter father's surname: ");
                    String f_surname = scan.nextLine();
                    System.out.print("Enter father's birth year: ");
                    int f_bYear;
                    while (true){
                        try{
                            f_bYear = Integer.parseInt(scan.nextLine());
                            if(f_bYear < 1900 || f_bYear >= 2050) throw new IllegalArgumentException();
                            break;
                        } catch (Exception ex) {
                            System.out.print("Invalid year! Please enter again: ");
                        }
                    }
                    System.out.print("Enter father's month of birth: ");
                    int f_bMonth;
                    while (true){
                        try{
                            f_bMonth = Integer.parseInt(scan.nextLine());
                            if(f_bMonth > 12 || f_bMonth < 1) throw new IllegalArgumentException();
                            break;
                        } catch (Exception ex) {
                            System.out.print("Invalid month! Please enter again: ");
                        }
                    }
                    System.out.print("Enter father's birth day: ");
                    int f_bDay;
                    while (true){
                        try{
                            f_bDay = Integer.parseInt(scan.nextLine());
                            LocalDate.parse(String.format("%02d/%02d/%04d", f_bDay,
                                    f_bMonth, f_bYear), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                            break;
                        } catch (Exception ex) {
                            System.out.print("Invalid day! Please enter again: ");
                        }
                    }
                    System.out.print("Enter father's iq: ");
                    int f_iq;
                    while (true){
                        try{
                            f_iq = Integer.parseInt(scan.nextLine());
                            if(f_iq < 0 || f_iq > 100) throw new IllegalArgumentException();
                            break;
                        } catch (Exception ex) {
                            System.out.print("Invalid month! Please enter again: ");
                        }
                    }
                    //
                    controller.createNewFamily(new Man(f_name,f_surname,
                            String.format("%02d/%02d/%04d", f_bDay, f_bMonth, f_bYear), f_iq), new Woman(m_name,m_surname,
                            String.format("%02d/%02d/%04d",m_bDay,m_bMonth,m_bYear),m_iq));
                    System.out.println("Family created. ");
                    break;
                }

                case "7": {
                    System.out.print("Enter id: ");
                    int id;
                    try{
                        id = Integer.parseInt(scan.nextLine());
                        if(controller.deleteFamilyByIndex(id))
                            System.out.println("Family deleted");
                        else System.out.println("Family couldn't be deleted!...");
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid id!");
                    }
                    break;
                }

                case "8": {
                    boolean done = false;
                    while(!done) {
                        displayEditMenu();
                        switch (scan.nextLine()) {
                            case "1": {
                                int id;
                                Family fam;
                                System.out.print("Enter id: ");
                                try {
                                    id = Integer.parseInt(scan.nextLine());
                                    fam = controller.getFamilyById(id);
                                    System.out.print("Enter a name for child if it's a boy: ");
                                    String boy = scan.nextLine();
                                    System.out.print("Enter a name for child if it's a girl: ");
                                    String girl = scan.nextLine();
                                    controller.bornChild(fam, boy, girl);
                                    System.out.println("A new child is born...");
                                } catch (NumberFormatException | IndexOutOfBoundsException ex) {
                                    System.out.println("Invalid id!");
                                } catch (FamilyOverflowException ex){
                                    System.out.println(ex.getMessage());
                                }
                                break;
                            }

                            case "2": {
                                int id;
                                Family fam;
                                System.out.print("Enter id: ");
                                try {
                                    id = Integer.parseInt(scan.nextLine());
                                    fam = controller.getFamilyById(id);
                                    System.out.print("Enter child's name: ");
                                    String name = scan.nextLine();
                                    System.out.print("Enter child's surname: ");
                                    String surname = scan.nextLine();
                                    System.out.print("Enter child's birth year: ");
                                    int bYear = Integer.parseInt(scan.nextLine());
                                    System.out.print("Enter child's month of birth: ");
                                    int bMonth = Integer.parseInt(scan.nextLine());
                                    System.out.print("Enter child's birthday: ");
                                    int bDay = Integer.parseInt(scan.nextLine());
                                    System.out.print("Enter child's iq: ");
                                    int iq = Integer.parseInt(scan.nextLine());
                                    controller.adoptChild(fam,new Human(name,surname,String.format("%02d/%02d/%04d",
                                            bDay,bMonth,bYear),iq));
                                    System.out.println("Child adopted...");
                                } catch (NumberFormatException ex) {
                                    System.out.println("Invalid input!");
                                } catch (DateTimeParseException ex){
                                    System.out.println("Entered date is not valid!");
                                } catch (IndexOutOfBoundsException ex) {
                                    System.out.println("Invalid id!");
                                } catch (FamilyOverflowException ex){
                                    System.out.println(ex.getMessage());
                                }
                                break;
                            }

                            case "3": done = true; break;

                            default:
                                System.out.println("Enter one of the options!");
                        }
                    }
                    break;
                }

                case "9": {
                    System.out.print("Enter the age: ");
                    try {
                        controller.deleteAllChildrenOlderThan(Integer.parseInt(scan.nextLine()));
                        System.out.println("Children over specified age are removed...");
                    } catch (Exception ex) {
                        System.out.println("Invalid input!");
                    }
                    break;
                }

                case "exit":{
                    controller.close();
                    exit = true;
                } break;

                default:
                    System.out.println("Select item from 1 to 9 or type 'exit' to quit...\n"); break;
            }
        }
    }
}
