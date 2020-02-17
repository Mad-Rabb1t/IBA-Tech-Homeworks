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

        while (!victory){
            Scanner line = new Scanner(System.in);

            print(btf);

            System.out.println("Enter a line of fire: ");
            if(!line.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer from 1 to 5");
            }
            else{
                int y = line.nextInt();
                if(y>5 || y<1){
                System.out.println("Invalid input. Please enter an integer from 1 to 5");
            } else {
                while (true) {
                    Scanner cell = new Scanner(System.in);
                    System.out.println("Enter a cell in line of fire: ");
                    if (!cell.hasNextInt()) {
                        System.out.println("Invalid input. Please enter an integer from 1 to 5");
                    } else {
                        int x = cell.nextInt() ;
                        if(x>5 || x<1) System.out.println("Invalid input. Please enter an integer from 1 to 5");
                        else {

                            if(y-1==target_y && x-1==target_x){
                               btf[y-1][x-1] = "X";
                               victory = true;
                               print(btf);
                            }
                            else {
                                btf[y-1][x-1] = "*";
                            }


                            break;
                        }
                    }
                }
                //break;
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
}
