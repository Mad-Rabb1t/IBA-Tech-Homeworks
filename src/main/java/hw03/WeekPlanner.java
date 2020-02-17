package hw03;

import java.util.Scanner;

public class WeekPlanner {
    public static void main(String[] args) {
        String[][] scedule = new String[7][2];
        //filling
        scedule[0][0] = "sunday";
        scedule[0][1] = "Do the homework";
        scedule[1][0] = "monday";
        scedule[1][1] = "Go to courses, watch a film";
        scedule[2][0] = "tuesday";
        scedule[2][1] = "Hang out with friends";
        scedule[3][0] = "wednesday";
        scedule[3][1] = "Do the workout";
        scedule[4][0] = "thursday";
        scedule[4][1] = "Play PS4";
        scedule[5][0] = "friday";
        scedule[5][1] = "Go to the cinema";
        scedule[6][0] = "saturday";
        scedule[6][1] = "Date a girl";
        //
        boolean valid = false;
        while(!valid){
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter the day of the week: ");
            String com = input.nextLine().toLowerCase().trim();

            switch(com){
                case "sunday": {
                    System.out.println("Your tasks for Sunday: " + scedule[0][1]);
                    break;
                }
                case "monday": {
                    System.out.println("Your tasks for Monday: " + scedule[1][1]);
                    break;
                }
                case "tuesday":  {
                    System.out.println("Your tasks for Tuesday: " + scedule[2][1]);
                    break;
                }
                case "wednesday": {
                    System.out.println("Your tasks for Wednesday: " + scedule[3][1]);
                    break;
                }
                case "thursday": {
                    System.out.println("Your tasks for Thursday: " + scedule[4][1]);
                    break;
                }
                case "friday": {
                    System.out.println("Your tasks for Friday: " + scedule[5][1]);
                    break;
                }
                case "saturday": {
                    System.out.println("Your tasks for Saturday: " + scedule[6][1]);
                    break;
                }
                case "exit": {
                    valid = true;
                    break;
                }
                default: {System.out.println("Sorry, I don't understand you, please try again."); }
            }
        }

    }
}
