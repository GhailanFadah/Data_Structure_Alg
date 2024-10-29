/*
Author: Ghailan Fadah
Course: 231
class: CatSocialAgent 
Date: 10/22/21
Description: creates an Agent object at a certain x and y postion with a certain 
radius as well as category. is a subclass of SocialAgent therefore it extends it. 
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;


public class CatSocialAgent extends SocialAgent {

    // fields for the class
    protected int category;

    // constructor
    public CatSocialAgent(double x0, double y0, int rad, int cat) {
        super(x0, y0, rad);
        category = cat;
    }

    // returns field category
    public int getCategory() {
        return this.category;
    }

    // toString method returns a String of the agents category type
    public String toString() {
        String results = "";

        results += this.category;

        return results;

    }

    // overrides the draw method of the superclass agent
    @Override
    public void draw(Graphics g) {

        // checks category type and sets it to its color
        if (this.getCategory() == 10) {

            g.setColor(Color.DARK_GRAY);
            g.fillOval((int) this.getX(), (int) this.getY(), 7, 7);
        }

        // checks if the agent also moved or not and updates color
        if (moved && this.getCategory() == 10) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval((int) this.getX(), (int) this.getY(), 7, 7);

        }

        // checks category type and sets it to its color
        if (this.getCategory() == 20) {

            g.setColor(Color.cyan);
            g.fillOval((int) this.getX(), (int) this.getY(), 7, 7);

        }

        // checks if the agent also moved or not and updates color
        if (moved && this.getCategory() == 20) {

            g.setColor(Color.BLUE);
            g.fillOval((int) this.getX(), (int) this.getY(), 7, 7);

        }

    }

    // overrides the update method of the superclass agent
    @Override
    // either moves the agent or not based on certain conditions
    public void updateState(Landscape scape) {

        // sets moved field to false
        this.moved = false;

        // creates to arrayLists
        ArrayList<Agent> array = new ArrayList<Agent>();
        ArrayList<CatSocialAgent> arrayCat = new ArrayList<CatSocialAgent>();

        // sets the array arrayList equal to the arraylist given by getNeighbors
        array = scape.getNeighbors(this.getX(), this.getY(), this.getRadius());

        // calls each agent in the list and cobverts them into a CatSocialAgent and
        // lastly adds them to the arrayCat arraylist
        for (Agent agent : array) {
            CatSocialAgent CatAgent = (CatSocialAgent) (agent);
            arrayCat.add(CatAgent);
        }

        // creates a random object
        Random ran = new Random();

        // creates a random x and y from range 10 to -10
        double randomX = ran.nextInt(21) - 10 - ran.nextDouble();
        double randomY = ran.nextInt(21) - 10 - ran.nextDouble();

        int counter = 0;

        /*
         * checks if the current agent has atleast 2 neighbors beside itself checks also
         * that atleast 1 more than half of its neighbors are the same category if so
         * then there is a 1% chance that the agent is moved randomly else the agent is
         * moved randomly since it has less than 3 neighbors
         */
        for (int i = 0; i < arrayCat.size(); i++) {
            arrayCat.get(i).getCategory();
            if (arrayCat.get(i).getCategory() == arrayCat.get(arrayCat.size() - 1).getCategory()) {
                counter++;
            }

        }

        if (arrayCat.size() >= 3 && counter > arrayCat.size() / 2) {

            int chance = ran.nextInt(99);
            if (chance == 1) {

                // adds the change to x and y position
                this.setX(this.getX() + randomX);
                this.setY(this.getY() + randomY);

                // sets move field to true
                this.moved = true;

            }

        } else {

            // adds the change to x and y position
            this.setX(this.getX() + randomX);
            this.setY(this.getY() + randomY);

            // sets move field to true
            this.moved = true;
        }

    }

    public static void main(String[] args) {
        // CatSocialAgent agent = new CatSocialAgent(3, 4, 2, 5);
        // System.out.println(agent.getX());
        // System.out.println(agent.getY());
        // agent.setX(5);
        // agent.setY(6);
        // System.out.println(agent.getX());
        // System.out.println(agent.getY());
        // agent.setRadius(5);
        // System.out.println(agent.getRadius());
        // System.out.println(agent.getCategory());

    }

}
