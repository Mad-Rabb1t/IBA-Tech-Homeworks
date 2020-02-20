package hw02;

import java.util.Scanner;

public class ShootingTheSquare {
    public static void main(String[] args) {

        String[][] btf = new String[5][5];

        for (int j =0;j<5;j++){
            for (int i =0; i<5;i++){
                btf[j][i]="-";
            }
        }

        int target_y = (int) (Math.random()*(5));
        int target_x = (int) (Math.random()*(5));
        boolean victory = false;


        System.out.println("All set. Get ready to rumble!");
        Scanner scan = new Scanner(System.in);
        print(btf);
        boolean st2 = false;
        int x;
        int y=0;

            while (!victory){
                print(btf);

                if (!st2) {
                    System.out.println("Enter a line of fire: ");
                    String input = scan.nextLine();
                    if (!isValid(input)) {
                        System.out.println("Invalid input. Please enter an integer from 1 to 5");
                    } else {
                        y = Integer.parseInt(input);
                        st2 = true;
                    }
                }
                if(st2){
                    System.out.println("Enter a cell in the line of fire: ");
                    String input = scan.nextLine();
                    if (!isValid(input)){
                        System.out.println("Invalid input. Please enter an integer from 1 to 5");
                    } else {
                        x = Integer.parseInt(input);
                        st2 = false;

                        if(y-1==target_y && x-1==target_x){
                            btf[y-1][x-1] = "X";
                            victory = true;
                            print(btf);
                        }
                        else {
                            btf[y-1][x-1] = "*";
                        }

                    }
                }



            }

        }



    public static void print (String[][] x){
        System.out.print("0 |");
        for(int i = 0; i< x.length; i++){
            System.out.print(" " + (i+1)+ " |");
        }
        System.out.println();
        for(int j = 0; j< x.length;j++){
            System.out.print((j+1)+" |");
            for(int i = 0;i<x.length;i++){
                System.out.print(" " + (x[j][i]) + " |");
            }
            System.out.println();
        }

    }
    public static boolean isValid (String check) {
        try{
           Integer.parseInt(check);
        } catch (Exception e) {
            return false;
        }
        int i = Integer.parseInt(check);
        return i <= 5 && i >= 1;

    }
}
