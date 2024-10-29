/*
Author: Ghailan Fadah
Course: 231
class: Pick2Customer
Date: 10/30/21
Description: creates a customer that picks to random line and chooses the shorter one to checkout at
*/


import java.util.ArrayList;
import java.util.Random;

public class Pick2Customer extends Customer{

    // constructor 
    public Pick2Customer(int numItems) {
        super(numItems);
        this.time = 2;
    }

    // overrides the abstract method
    // chooses the shorter line from 2 random chosen lines
    @Override
    public int chooseLine(ArrayList<CheckoutAgent> checkouts) {

        // creates an arraylist of integers
        ArrayList<Integer> list = new ArrayList<Integer>();

        // creates random object
        Random rand = new Random();

        // for each loop: loops over all the agents in the checkoutAgent list and adds
        // the number of customers in thier queue to the arraylist
        for(CheckoutAgent agent : checkouts){
        
            list.add(agent.getNumInQueue());

        }

        // creates a random number from 0 to the list size (exclusive)
        int randNum = rand.nextInt(list.size());

        // gets the element at the random index and sets line1 as it.
        int line1 = list.get(randNum);

        // keeps up with the index of the element
        int IndexLine1 = list.indexOf(line1);

        // removes the element from the list
        list.remove(randNum);

        // creates another number from 0 to the size of the smaller list
        int randNum2 = rand.nextInt(list.size());

        // gets the element at the random index and sets it equal to line 2
        int line2 = list.get(randNum2);

        // compares what line is shorter and returns its index
        if (line1 < line2){
            return IndexLine1;
        }

        return list.indexOf(line2);
    }
    
}