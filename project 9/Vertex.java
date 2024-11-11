/*
Author: Ghailan Fadah
Course: 231
class: Vertex
Date: 12/12/21
Description: creates a vertex for a graph  
*/

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

public class Vertex implements Comparable<Vertex> {

    // fields for the class
    private ArrayList<Vertex> neigbors;
    private int xPos;
    private int yPos;
    private boolean visible;
    private boolean mark;
    private double distance;
    private Vertex parent;
    private Direction direction;

    // enum class for game
    public enum Direction {
        WEST,
        EAST,
        NORTH,
        SOUTH;
    }

    // method for game
    public static Direction opposite(Direction direction) {
        if (direction == Direction.NORTH) {
            return Direction.SOUTH;
        } else if (direction == Direction.SOUTH) {
            return Direction.NORTH;
        } else if (direction == Direction.EAST) {
            return Direction.WEST;
        } else {
            return Direction.EAST;
        }
    }

    // constructor
    public Vertex(int x, int y, boolean mark, boolean vis, double dis, Vertex par) {

        this.neigbors = new ArrayList<Vertex>();
        this.xPos = x;
        this.yPos = y;
        this.visible = vis;
        this.mark = mark;
        this.distance = dis;
        this.parent = par;

    }

    // constructor
    public Vertex(int x, int y, boolean mar) {
        this.neigbors = new ArrayList<Vertex>();
        this.xPos = x;
        this.yPos = y;
        this.mark = mar;
        this.distance = 0;
        this.parent = null;
        this.visible = true;
    }

    // constructor
    public Vertex(int x, int y) {
        this.xPos = x;
        this.yPos = y;

    }

    // setter for position
    public void setPos(int x, int y) {

        this.xPos = x;
        this.yPos = y;

    }

    // getter for xpos
    public int getX() {
        return this.xPos;
    }

    // getter for ypos
    public int getY() {
        return this.yPos;
    }

    // set for visible field
    public void setVisible(boolean vis) {
        this.visible = vis;
    }

    // getter for visible field
    public boolean getVisible() {
        return this.visible;
    }

    // setter for mark
    public void setMark(boolean mar) {
        this.mark = mar;
    }

    // getter for mark
    public boolean getMark() {
        return this.mark;
    }

    // setter for parent field
    public void setParent(Vertex par) {
        this.parent = par;
    }

    // getter for parent field
    public Vertex getParent() {
        return this.parent;
    }

    // setter for distance field
    public void setDistance(double dis) {
        this.distance = dis;
    }

    // getter for distance field
    public double getDistance() {
        return this.distance;
    }

    // method that calculates the distance in Euclean form
    public double distance(Vertex other) {

        double xDis = Math.pow((other.xPos - this.xPos), 2);
        double yDis = Math.pow(other.yPos - this.yPos, 2);

        double dis = Math.sqrt(xDis + yDis);

        return dis;

    }

    // adds another vertex to the vertex's adjacenty list
    public void connect(Vertex other) {

        this.neigbors.add(other);

    }

    // returns the vertex at that position if it exists
    public Vertex getNeighbor(int x, int y) {

        // loops over all the vertices in the adjacenty list
        for (Vertex v : neigbors) {

            // if any of the vertices have the same x and y as the given ones then return it
            if (v.xPos == x && v.yPos == y) {
                return v;
            }
        }

        // else return null

        return null;

    }

    // returns an arrayList of all the neighbors of the vertex
    public ArrayList<Vertex> getNeighbors() {
        return this.neigbors;
    }

    // returns the number of neighbors a vertex has
    public int numNeighbors() {
        return this.neigbors.size();
    }

    // toString method: tells the distance, number of neighbors, and if it has been
    // visited
    public String toString() {

        String result = "";

        result += "(" + this.distance + ", " + this.numNeighbors() + ", " + this.mark + ", " + "(" + this.getX() + ","
                + this.getY() + ")" + ")";

        return result;

    }

    // compare method: determines which vertex is bigger based on its distance field
    public int compareTo(Vertex other) {

        // if distance is less than other distance return -1
        if (this.distance < other.distance) {
            return -1;
        }

        // if distance is more than other distance return 1
        if (this.distance > other.distance) {
            return 1;
        }

        // else equal so return 0

        return 0;
    }

    // deterines if two vertices are at the same position or not
    public static boolean matchPosition(Vertex a, Vertex b) {

        return (a.xPos == b.xPos && a.yPos == b.yPos);
    }

    // draw method for game
    public void draw(Graphics g, int scale) {
        if (!this.visible)
            return;
        int xpos = (int) this.getX() * scale;
        int ypos = (int) this.getY() * scale;
        int border = 2;
        int half = scale / 2;
        int eighth = scale / 8;
        int sixteenth = scale / 16;

        // draw rectangle for the walls of the room
        if (this.getDistance() <= 2)
            // wumpus is nearby
            g.setColor(Color.red);
        else
            // wumpus is not nearby
            g.setColor(Color.black);

        g.drawRect(xpos + border, ypos + border, scale - 2 * border, scale - 2 * border);

        // draw doorways as boxes
        g.setColor(Color.black);
        if (this.getNeighbor(this.getX(), this.getY() - 1) != null)
            g.fillRect(xpos + half - sixteenth, ypos, eighth, eighth + sixteenth);
        if (this.getNeighbor(this.getX(), this.getY() + 1) != null)
            g.fillRect(xpos + half - sixteenth, ypos + scale - (eighth + sixteenth),
                    eighth, eighth + sixteenth);
        if (this.getNeighbor(this.getX() - 1, this.getY()) != null)
            g.fillRect(xpos, ypos + half - sixteenth, eighth + sixteenth, eighth);
        if (this.getNeighbor(this.getX() + 1, this.getY()) != null)
            g.fillRect(xpos + scale - (eighth + sixteenth), ypos + half - sixteenth,
                    eighth + sixteenth, eighth);
    }

    // testing area
    public static void main(String[] args) {
        Vertex ver = new Vertex(5, 4, true, true, 5.5, null);
        Vertex ver1 = new Vertex(1, 1, true, true, 5.5, null);

        System.out.println(ver1.distance(ver));
        ver.connect(ver1);
        System.out.println(ver.numNeighbors());
        System.out.println(ver.getNeighbor(1, 1));

        System.out.println(ver.matchPosition(ver, ver1));
        System.out.println(ver.compareTo(ver1));
    }

}
