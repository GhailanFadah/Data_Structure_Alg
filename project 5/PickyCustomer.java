/*
Author: Ghailan Fadah
Course: 231
class: PickyCustomer
Date: 10/30/21
Description: creates a customer that picks compares all the lines and chooses the smallest one
*/

import java.util.ArrayList;
import java.util.Collections;

public class PickyCustomer extends Customer{

    // constructor
    public PickyCustomer(int numItems, int numLines) {
        super(numItems);
        this.time = numLines;
 
    }

    // overrides the abstract method
    // chooses the shortest line 
    @Override
    public int chooseLine(ArrayList<CheckoutAgent> checkouts) {

        // creates an arraylist of integers
        ArrayList<Integer> list = new ArrayList<Integer>();

        // for each loop: loops over all the agents in the checkoutAgent list and adds
        // the number of customers in thier queue to the arraylist
        for(CheckoutAgent agent : checkouts){
        
            list.add(agent.getNumInQueue());

        }

        // returns the index of the smallest line in list
        return list.indexOf(Collections.min(list));
    }
    
}