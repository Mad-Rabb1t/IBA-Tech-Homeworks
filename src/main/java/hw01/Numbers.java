package hw01;


import java.util.Arrays;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String g_type ;

        System.out.println("Enter your name please: ");
        String name = scan.nextLine();
        System.out.printf("Select which game to play, %s: number guessing or event guessing (Enter \"number\" or \"event\"): \n", name);
        g_type = scan.next().toLowerCase().trim();
        while (!g_type.equals("number") && !g_type.equals("event")){
            System.out.println("Invalid input. Please enter: \"number\" or \"event\" ");
            g_type = scan.next().toLowerCase().trim();
        }
        System.out.println("Let the game begin! ");

        int num = (int) (Math.random()*(100 + 1));
        int e_num = (int) (Math.random()*(5));


        if(g_type.equals("number")){

            int init_size = 10;
            int[] log = new int[init_size];
            int k = -1;

            while(true) {

                if(k==init_size -1){
                    log = Arrays.copyOf(log,init_size*2);

                }
                System.out.println("Make a guess:");
                Scanner temp = new Scanner(System.in);

                if (!temp.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer");

                } else {
                    k++;
                    log[k] = temp.nextInt();

                    if (log[k] < num) {
                        System.out.println("Your number is too small. Please, try again.");
                    } else if (log[k] > num) {
                        System.out.println("Your number is too big. Please, try again.");
                    } else {
                        int[] flog = Arrays.copyOf(log, k + 1);
                        Arrays.sort(flog);
                        //reversing
                        for (int i = 0; i <= flog.length / 2; i++) {
                            int tmp = flog[i];
                            flog[i] = flog[flog.length - 1 - i];
                            flog[flog.length - 1 - i] = tmp;
                        }
                        //
                        System.out.printf("Congratulations, %s!\n", name);
                        System.out.println("Your numbers: " + Arrays.toString(flog));
                        break;
                    }

                }
            }
        }

        if(g_type.equals("event")) {
            int init_size = 5;
            int[] log = new int[init_size];
            int k = -1;

            String[][] data = {{"1939", "When did the World War II begin?"}, {"1918", "When did the World War I end?"},
                    {"1969", "When did Apollo 11 land on the moon?"}, {"2019", "When was the first registered outbreak of CoronaVirus?"},
                    {"2008", "When did the 1st movie of \"MARVEL Cinematic Universe\" come out?"}};

            while (true) {

                if(k==init_size-1){
                    log = Arrays.copyOf(log,init_size*2);
                }

                System.out.println(data[e_num][1]);
                Scanner temp = new Scanner(System.in);

                if (!temp.hasNextInt()) {
                    System.out.println("Invalid input. Please enter an integer");

                } else {
                    k++;
                    log[k] = temp.nextInt();

                    if (log[k] < Integer.parseInt(data[e_num][0])) {
                        System.out.println("Your number is too small. Please, try again.");
                    } else if (log[k] > Integer.parseInt(data[e_num][0])) {
                        System.out.println("Your number is too big. Please, try again.");
                    } else {
                        int[] flog = Arrays.copyOf(log, k + 1);
                        Arrays.sort(flog);
                        //reversing
                        for (int i = 0; i <= flog.length / 2; i++) {
                            int tmp = flog[i];
                            flog[i] = flog[flog.length - 1 - i];
                            flog[flog.length - 1 - i] = tmp;
                        }
                        //
                        System.out.printf("Congratulations, %s!\n", name);
                        System.out.println("Your numbers: " + Arrays.toString(flog));
                        break;
                    }

                }


            }
        }




        }


    }
