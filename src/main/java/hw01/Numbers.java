package hw01;

import java.util.Arrays;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);


        System.out.println("Enter your name please: ");
        String name = scan.nextLine();
        System.out.println("Let the game begin! ");
        String[][] data = {{"1939","When did the World War II begin?"},{"1918","When did the World War I end?"},
                {"1969","When did Apollo 11 land on the moon?"},{"2019","When was the first registered outbreak of CoronaVirus?"},
                {"2008","When did the 1st movie of \"MARVEL Cinematic Universe\" come out?"}};

        int num = (int) (Math.random()*(5));
        int[] log = new int[100];
        int k = -1;

        while(true){

            System.out.println(data[num][1]);
            Scanner temp = new Scanner(System.in);

            if(!temp.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer");

            }
            else {
                k++;
                log[k] = temp.nextInt();

                if(log[k] < Integer.parseInt(data[num][0]) ) {
                    System.out.println("Your number is too small. Please, try again.");
                }
                else if(log[k]>Integer.parseInt(data[num][0])) {
                    System.out.println("Your number is too big. Please, try again.");
                }
                else {
                    int[] flog = Arrays.copyOf(log, k+1);
                    Arrays.sort(flog);
                    //reversing
                    for(int i=0; i <= flog.length / 2; i++){
                        int tmp = flog[i];
                        flog[i] = flog[flog.length - 1 - i];
                        flog[flog.length - 1 - i] = tmp;
                    }
                    //
                    System.out.printf("Congratulations, %s!\n",name);
                    System.out.println("Your numbers: " + Arrays.toString(flog));
                    break;}

            }





            }




        }






    }
