/*
Author: Ghailan Fadah
Course: 231
class: CheckoutAgent
Date: 10/30/21
Description: creates a checkoutAgent at an x, y position with a line as a queue
*/

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class CheckoutAgent {

    // fields for the class
    private int xPos;
    private int yPos;
    private MyQueue<Customer> queue;
    private int itemsQueue;

    // constructor
    public CheckoutAgent(int x, int y) {
        xPos = x;
        yPos = y;
        queue = new MyQueue<Customer>();
        itemsQueue = 0;
    }

    public void setItemsQueue(int val) {

        itemsQueue += val;

    }

    public int getItemsQueue() {

        return itemsQueue;
    }

    // adds a customer to the queue
    public void addCustomerToQueue(Customer c) {
        queue.offer(c);
        setItemsQueue(c.getNumItems());
    }

    // getter for the size of the queue
    public int getNumInQueue() {
        return this.queue.getSize();
    }

    // draw method: draws a rectangle that represents a checkoutAgent
    public void draw(Graphics g) {

        // converts the total items in a line to a string
        String value = String.valueOf(this.getItemsQueue());

        // creates 3 random floats
        Random rand = new Random();
        float r = rand.nextFloat();
        float gr = rand.nextFloat();
        float b = rand.nextFloat();

        // uses the 3 random numbers to create a new color
        Color randomColor = new Color(r, gr, b);

        // creates the desired height
        int desiredHeight = 10 * getNumInQueue();

        // sets the color to random
        g.setColor(randomColor);

        // draws a rectangle with a random color
        g.fillRect(this.xPos, this.yPos - desiredHeight, 10, desiredHeight);

        // draws the total items in each line
        g.drawString(value, this.xPos, this.yPos - desiredHeight);

        int check = this.yPos;

        // sets color to black before entering for loop
        g.setColor(Color.black);

        /*
         * for each loop: converts each each customer's items to a string and assigns it
         * to val draws the value at each customers location in the rectangle.
         */
        for (Customer cust : this.queue) {

            String val = String.valueOf(cust.getNumItems());
            g.drawString(val, this.xPos, check);
            check += -10;
        }

    }

    // updates the state of the checkoutAgent
    public void updateState(Landscape scape) {

        // for each loop: loops over all the customers in the queue and adds one to the
        // wait time field
        for (Customer customer : queue) {
            customer.incrementTime();
        }

        // variable for the front customer
        Customer frontCustomer = queue.peek();

        /*
         * if there is no customer in the queue than nothing happens if there is than
         * remove one item from their item field checks to see if their item field is
         * equal to 0 if so then remove them from the queue and add them to the finshed
         * customer list
         */
        if (frontCustomer == null) {

        } else {
            frontCustomer.giveUpItem();
            setItemsQueue(-1);
            if (frontCustomer.getNumItems() == 0) {

                // variable to hold the finshed customer
                Customer finshedCustomer = queue.poll();
                scape.addFinishedCustomer(finshedCustomer);
                ;

            }
        }
    }

    // used for testing
    public static void main(String[] args) {

        // CheckoutAgent check = new CheckoutAgent(10, 10);
        // CheckoutAgent check2 = new CheckoutAgent(10, 10);
        // RandomCustomer cust = new RandomCustomer(10);
        // RandomCustomer custs = new RandomCustomer(10);
        // RandomCustomer custt = new RandomCustomer(10);
        // Pick2Customer cust1 = new Pick2Customer(5);
        // Pick2Customer cust2 = new Pick2Customer(5);
        // Pick2Customer cust3 = new Pick2Customer(5);
        // Pick2Customer cust4 = new Pick2Customer(5);
        // Pick2Customer cust5 = new Pick2Customer(5);
        // ExtraPickyCustomer cust6 = new ExtraPickyCustomer(5, 8);

        // check.queue.offer(cust);
        // check.queue.offer(custs);
        // check.addCustomerToQueue(cust);
        // check.addCustomerToQueue(custs);
        // check2.addCustomerToQueue(custt);

        // System.out.println(check.itemsQueue);
        // System.out.println(check2.itemsQueue);

        // custt.incrementTime();
        // custs.time =+ 32;
        // custt.time =+ 12;
        // cust1.time =+ 55;
        // cust2.time =+ 10;
        // cust3.time =+ 23;
        // cust4.time =+ 14;
        // cust5.time =+ 30;

        // check.queue.offer(cust);
        // ArrayList<CheckoutAgent> checkouts = new ArrayList<CheckoutAgent>();
        // checkouts.add(check);
        // checkouts.add(check2);
        // Landscape scape = new Landscape(20, 20, checkouts);
        // System.out.println(scape.getTotalItems());
        // scape.updateCheckouts();
        // System.out.println(scape.getTotalItems());

        // System.out.println(check.itemsQueue);
        // System.out.println(check2.itemsQueue);

        // scape.addFinishedCustomer(cust1);
        // scape.addFinishedCustomer(cust2);
        // scape.addFinishedCustomer(cust3);
        // scape.addFinishedCustomer(cust4);
        // scape.addFinishedCustomer(cust5);
        // scape.addFinishedCustomer(cust);
        // scape.addFinishedCustomer(custs);
        // scape.addFinishedCustomer(custt);

        // scape.printFinishedCustomerStatistics();

    }

}