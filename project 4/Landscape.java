/*
Author: Ghailan Fadah
Course: 231
class: Landscape 
Date: 10/22/21
Description: creates a landscape with a certain height, width, and a linkedlist of agents
*/

import java.awt.Graphics;
import java.util.ArrayList;

public class Landscape {

    // fields for the class
    private int height;
    private int width;
    private LinkedList<Agent> list;

    // constructor
    public Landscape(int w, int h) {
        this.width = w;
        this.height = h;

        // creates a linkedlist of agents
        this.list = new LinkedList<Agent>();
    }

    // getter for the height field
    public int getHeight() {
        return this.height;
    }

    // getter for the width field
    public int getWidth() {
        return this.width;
    }

    // adds an agent to the agent linkedlist
    public void addAgent(Agent a) {
        this.list.addFirst(a);
    }

    // ToString method: returns the number of agents in the landscape
    public String toString() {
        String result = "Number of agents in the Landscape " + this.list.size();

        return result;
    }

    /*
     * takes in a x, y, and radius and returns a list of agents within that circle
     * using the formula for a circle
     */
    public ArrayList<Agent> getNeighbors(double x0, double y0, double radius) {

        // creates two Arraylists of agents called neighborsList and tempList
        ArrayList<Agent> neighborsList = new ArrayList<Agent>();
        ArrayList<Agent> tempList = new ArrayList<Agent>();

        // converts the linkedlist into an arraylist using the method and setting it
        // equal to templist
        tempList = this.list.toArrayList();

        // squares the radius
        double rSquared = radius * radius;

        // for loop goes over all the elements in the arrayList tempList
        for (int i = 0; i < tempList.size(); i++) {

            // finds the change in x
            double dx = (tempList.get(i).getX() - x0);

            // finds the change in y
            double dy = (tempList.get(i).getY() - y0);

            /*
             * checks that the agent is in the circle if so then it is added to the
             * neighborsList else it is ignored
             */
            if ((dx * dx + dy * dy) <= rSquared) {
                neighborsList.add(tempList.get(i));
            }

        }

        // returns the neighbor ArrayList
        return neighborsList;
    }

    // uses a for each loop to get each agent and call its draw method
    public void draw(Graphics g) {

        for (Agent agent : list) {
            agent.draw(g);
        }
    }

    // calls the update method on each agent in a random order
    public void updateAgents() {

        // creates an arrayList called shuffledArray
        ArrayList<Agent> shuffledArray = new ArrayList<Agent>();

        // sets shuffledArray equal to the converted shuffled linkedlist which is now an
        // arrayList
        shuffledArray = list.toShuffledList();

        // for each loop gets each agent and calls its updateState method
        for (Agent agent : shuffledArray) {
            agent.updateState(this);
        }

    }

    // testing code
    public static void main(String[] args) {
        // Landscape scape = new Landscape(50, 50);
        // CatSocialAgent agent1 = new CatSocialAgent(5, 5, 5, 2);
        // CatSocialAgent agent2 = new CatSocialAgent(5, 5, 5, 2);
        // CatSocialAgent agent3 = new CatSocialAgent(5, 5, 5, 2);
        // CatSocialAgent agent4 = new CatSocialAgent(5, 5, 5, 2);
        // scape.addAgent(agent1);
        // scape.addAgent(agent2);
        // scape.addAgent(agent3);
        // scape.addAgent(agent4);
        // // System.out.println(scape);
        // agent1.updateState(scape);

        // System.out.println(agent1.getX());
        // System.out.println(agent1.getY());

        // System.out.println(scape.getNeighbors(agent1.getX(), agent1.getY(),
        // agent1.getRadius()));
        // scape.getNeighbors(0, 0, 3);

        // System.out.println(scape.getHeight());
        // System.out.println(scape.getWidth());
        // System.out.println(scape);
        // System.out.println(scape.getNeighbors(agent1.xPosition, agent1.getY(), 15));
    }
}