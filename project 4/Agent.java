/*
Author: Ghailan Fadah
Course: 231
class: Agent 
Date: 10/22/21
Description: creates an Agent object at a certain x and y postion
*/

import java.awt.Graphics;

public class Agent {

    // fields for the class
    protected double xPosition;
    protected double yPosition;

    // constructor
    public Agent(double x0, double y0) {
        this.xPosition = x0;
        this.yPosition = y0;
    }

    // getter for x position
    public double getX() {
        return this.xPosition;
    }

    // getter for y position
    public double getY() {
        return this.yPosition;
    }

    // setter for x position
    public void setX(double newX) {
        this.xPosition = newX;
    }

    // setter for y position
    public void setY(double newY) {
        this.yPosition = newY;
    }

    // string method: returns the x and y position of an agent
    public String toString() {

        String result = "";

        result += "(" + this.xPosition + ", " + this.yPosition + ')';

        return result;
    }

    // update method
    public void updateState(Landscape scape) {
    }

    // draw method
    public void draw(Graphics g) {
    }

    // testing code
    public static void main(String[] args) {

        // Agent agent = new Agent(3,4);

        // System.out.println(agent.getX());
        // System.out.println(agent.getY());
        // agent.setX(5);
        // agent.setY(6);
        // System.out.println(agent.getX());
        // System.out.println(agent.getY());

    }
}