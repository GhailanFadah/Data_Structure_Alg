/*
Author: Ghailan Fadah
Course: 231
class: RandomCustomer
Date: 10/30/21
Description: creates a customer that chooses a random line to chechout at 
*/

import java.util.ArrayList;
import java.util.Random;

public class RandomCustomer extends Customer {

    // constructor
    public RandomCustomer(int numItems) {
        super(numItems);
        this.time = 1;
    }

    // overrides the abstract method
    // chooses a random line to checkout at
    @Override
    public int chooseLine(ArrayList<CheckoutAgent> checkouts) {

        // creates a random object
        Random rand = new Random();

        // returns a random integar from 0 to the size of the checkouts list.
        return rand.nextInt(checkouts.size());
    }

}