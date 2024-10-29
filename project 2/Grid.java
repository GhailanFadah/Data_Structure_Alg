/*
File: Grid.java
Author: Ghailan Fadah
Date: 09/13/2021
*/

import java.util.Random;

public class Grid {
    public static void main(String [] args){
        // tells the user how to run the program
        if(args.length <= 0){
            System.out.print("Usage: program requires atleast one argument");
            return;
        }

        // loops over args and prints out each index
        for(int i = 0; i < args.length; i++){
            System.out.println(args[i]);
        }
        int yogi = 2;
        int booboo = 2;

        // converts args[0] and args[1] to integers
        yogi = Integer.parseInt(args[0]);
        booboo = Integer.parseInt(args[1]);

        //creates a 2D array
        String[][] ranger = new String[yogi][booboo] ;
        
        Random random = new Random();
        
        // nested for loop that loops over the 2D array and adds a random char at each cell
        // prints out the 2D array
        for(int i = 0;i < yogi;i++) {
            System.out.print('\n');
            for(int j = 0;j < booboo;j++){
                ranger[i][j] = String.valueOf((char) ('a' + random.nextInt(26)));
                System.out.print(ranger[i][j]);
            }
        }
        



        
    }
}
