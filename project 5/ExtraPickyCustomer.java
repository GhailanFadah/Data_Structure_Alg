import java.util.ArrayList;
import java.util.Collections;

public class ExtraPickyCustomer extends Customer {

    public ExtraPickyCustomer(int numItems, int numQueueItems) {
        super(numItems);
        this.time = numQueueItems;

    }

    // overrides the abstract method
    // chooses the line with the fewest items
    @Override
    public int chooseLine(ArrayList<CheckoutAgent> checkouts) {

        // creates an arraylist of integers
        ArrayList<Integer> list = new ArrayList<Integer>();

        // for each loop: loops over all the agents in the checkoutAgent list and adds
        // the number of customers in thier queue to the arraylist
        for (CheckoutAgent agent : checkouts) {

            list.add(agent.getItemsQueue());

        }

        // returns the index of the line with the fewest items in it in the list
        return list.indexOf(Collections.min(list));
    }

}