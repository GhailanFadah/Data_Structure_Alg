/*
Author: Ghailan Fadah
Course: 231
class: SocialAgent 
Date: 10/22/21
Description: creates an Agent object at a certain x and y postion with a certain 
radius with it. is a subclass of Agent therefore it extends it. 
*/

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class SocialAgent extends Agent {

    // fields for the class
    protected boolean moved;
    protected int radius;

    // constructor
    public SocialAgent(double x0, double y0, int rad) {
        super(x0, y0);
        this.radius = rad;
    }

    // setter for the radius
    public void setRadius(int radius) {
        this.radius = radius;
    }

    // getter for the radius
    public int getRadius() {
        return this.radius;
    }

    // overrides the draw method of the superclass agent
    @Override
    public void draw(Graphics g) {

        /*
         * draws a circle with radius 5 if the agent field move is true it draws it with
         * light grey else it draws it with dark grey
         */
        if (moved) {
            g.setColor(Color.LIGHT_GRAY);
            g.fillOval((int) this.getX(), (int) this.getY(), 7, 7);

        } else {
            g.setColor(Color.DARK_GRAY);
            g.fillOval((int) this.getX(), (int) this.getY(), 7, 7);
        }

    }

    // overrides the update method of the superclass agent
    @Override
    // either moves the agent or not based on certain conditions
    public void updateState(Landscape scape) {

        // sets the move field to false
        this.moved = false;

        // creates a random object
        Random ran = new Random();

        // creates a random x and y from range 10 to -10
        double randomX = ran.nextInt(20) - 10 + ran.nextDouble();
        double randomY = ran.nextInt(20) - 10 + ran.nextDouble();

        /*
         * checks if the current agent has atleast 3 neighbors beside itself if so then
         * there is a 1% chance that the agent is moved randomly else the agent is moved
         * randomly since it has less than 3 neighbors
         */
        if (scape.getNeighbors(this.getX(), this.getY(), this.getRadius()).size() > 3) {
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

    // testing code
    public static void main(String[] args) {

        // SocialAgent agent = new SocialAgent(3, 4, 2);
        // // testing methods
        // System.out.println(agent.getX());
        // System.out.println(agent.getY());
        // agent.setX(5);
        // agent.setY(6);
        // System.out.println(agent.getX());
        // System.out.println(agent.getY());
        // agent.setRadius(5);
        // System.out.println(agent.getRadius());

    }

}