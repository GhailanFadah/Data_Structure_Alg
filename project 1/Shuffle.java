/*
File: Shuffle.java
Author: Ghailan Fadah
Date: 09/13/2021
*/
 
// imports random and ArrayLists 
import java.util.ArrayList;
import java.util.Random;

public class Shuffle  {
    public static void main ( String[] args )	{
        
        // declares an ArrayList called "arr" and a random function called "ran"
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Random ran = new Random();

        int orderNumbers = 1;

        // a for loop that adds the numbers 1-10 to "arr" ArrayList
        for(int i = 0; i < 10; i++){

            // int val = ran.nextInt(100);
            // arr.add(val);
            arr.add(orderNumbers++);
            System.out.println(arr);
        }

        // a for loop that loops through "arr" and prints out each number in its indexes
        for(int i = 0; i < 10; i++){
            Integer number = arr.get(i);
            System.out.println(number);
        }

        // a for loop that removes a number from "arr" randomly and prints it and the remaining "arr" 
        for(int i = 0; i < 10; i++){
            int numRemoved = arr.remove(ran.nextInt(arr.size()));
            System.out.print(arr);
            System.out.println(numRemoved);

        }

    }
}
