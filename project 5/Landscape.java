/*
Author: Ghailan Fadah
Course: 231
class: Landscape 
Date: 10/30/21
Description: implends a landscape display for project 5:
displays the checkoutAgents lines as rectangles on the screen
*/

import java.util.ArrayList;
import java.awt.Graphics;

public class Landscape {

    // fields for the class
    private int width;
    private int height;
    private ArrayList<CheckoutAgent> listOfAgents;
    private LinkedList<Customer> listOfCustomers;
    private int totalItems;

    // constructor
    public Landscape(int w, int h, ArrayList<CheckoutAgent> checkouts) {

        this.width = w;
        this.height = h;

        this.listOfAgents = checkouts;
        listOfCustomers = new LinkedList<Customer>();

        // adds all the items in each line together and stores them in totalItems
        for (CheckoutAgent agent : this.listOfAgents){
            totalItems += agent.getItemsQueue();
        }
    }

    // getter for the height field
    public int getHeight() {
        return this.height;
    }

    // getter for the total items in the landscape
    public int getTotalItems(){

        return totalItems;
    }

    public void setTotalItems(){
        
        totalItems = 0;
        for (CheckoutAgent agent : this.listOfAgents){
            totalItems += agent.getItemsQueue();
        }
    }

    // getter for the width field
    public int getWidth() {
        return this.width;
    }

    // toSring method: returns the number of checkoutAgents, and the number of
    // customers finished
    public String toString() {
        String results = "";

        results += "number of checkout agents: " + this.listOfAgents.size();
        results += "\n" + "number of customers finshed : " + this.listOfCustomers.size();

        return results;
    }

    // adds a customer to the list of finished customers
    public void addFinishedCustomer(Customer c) {
        listOfCustomers.addFirst(c);
    }

    // draw method: calls the draw method for each checkoutAgent in the listOfAgents
    // list
    public void draw(Graphics g) {

        // for each loop
        for (CheckoutAgent agent : listOfAgents) {
            agent.draw(g);
        }
    }

    // update method: calls the update method for each checkoutAgent in the
    // listOfAgents list
    public void updateCheckouts() {

        // for each loop
        for (CheckoutAgent agent : listOfAgents) {
            agent.updateState(this);
        }

        this.setTotalItems();
    }

    // prints the statistical data on to the termnal
    public void printFinishedCustomerStatistics() {

        // variables
        double sum = 0.0;
        double standardDeviation = 0.0;
        double res = 0.0;
        double sq = 0.0;
        int n = listOfCustomers.size();

        // for each loop: finds the sum of the time field for all the customers in the
        // finshed list
        for (Customer customer : listOfCustomers) {
            sum += customer.getTime();

        }

        // finds the average
        double average = sum / n;

        // finds the answer to the top part of the equation (xi-x)^2
        for (Customer customer : listOfCustomers) {
            standardDeviation = standardDeviation + Math.pow(((double) customer.time - average), 2);
        }

        // finds the bottom part of the equation
        sq = standardDeviation / n;

        // finds the square root to complete the equation
        res = Math.sqrt(sq);

        // prints out the average and standard deviation
        System.out.println("(the average: " + average + ")" + "(the standard deviation: " + res + ")");

    }

}