/*
Author: Ghailan Fadah
Course: 231
class: Customer
Date: 10/30/21
Description: creates a customer with an abstract chooseline method
*/

import java.util.ArrayList;

public abstract class Customer {

    // fields for the class
    protected int items;
    protected int time;

    // default constructor
    public Customer(int numItems) {
        this.items = numItems;
        this.time = 0;
    }

    // constructor
    public Customer(int numItems, int timeSteps) {
        this.items = numItems;
        this.time = timeSteps;
    }

    // increases the time field by one
    public void incrementTime() {
        this.time++;
    }

    // getter for the time field
    public int getTime() {
        return this.time;
    }

    // takes one aaway from the items field
    public void giveUpItem() {
        this.items--;
    }

    // getter for the items field
    public int getNumItems() {
        return this.items;
    }

    // abstract method: chooses what line to checkout at
    public abstract int chooseLine(ArrayList<CheckoutAgent> checkouts);

    // toString method returns the the number of items and the number of time for
    // the customer (itmes, time)
    public String toString() {
        String results = "";

        results += "(" + this.getNumItems() + " " + this.getTime() + ")";

        return results;
    }

}
