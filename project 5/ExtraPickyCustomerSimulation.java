/*
Author: Ghailan Fadah
Course: 231
class: PickyCustomerSimulation
Date: 10/30/21
Description: creates a simulation of picky customers at a store
*/

import java.util.Random;
import java.util.ArrayList;

public class ExtraPickyCustomerSimulation {

    // function that creates a new LandscapeDisplay and populates it with 5
    // checkouts and 1000 ExtraPicky customers.
    public static void main(String[] args) throws InterruptedException {

        // creates random object
        Random gen = new Random();

        // creates an arraylist of size 5 of checkoutAgents
        ArrayList<CheckoutAgent> checkouts = new ArrayList<CheckoutAgent>(5);

        // adds five checkout agents to the the arraylist

        for (int i = 0; i < 5; i++) {
            CheckoutAgent checkout = new CheckoutAgent(i * 100 + 50, 480);
            checkouts.add(checkout);
        }
        
        // creates a ladnscape and displays the checkoutAgents
        Landscape scape = new Landscape(500, 500, checkouts);
        LandscapeDisplay display = new LandscapeDisplay(scape);

        // simulation of 1000 times
        int counter = 0;
        for (int j = 0; j < 1000; j++) {

            counter++;

            // creates a customer with a range of 1-5 items
            Customer cust = new PickyCustomer(1 + gen.nextInt(6), scape.getTotalItems());


            // calls the choose line method on the customer
            int choice = cust.chooseLine(checkouts);

            // adds the customer to a queue
            checkouts.get(choice).addCustomerToQueue(cust);

            // updates all the checkoutAgents
            scape.updateCheckouts();

            // repaints the screen
            display.repaint();

            // freezes screen
            Thread.sleep(0);

            // calls the printFinishedCustomerStatistics() every 100 intervals
            if (counter >= 100) {
                scape.printFinishedCustomerStatistics();
                counter = 0;
            }
        }

    }

}