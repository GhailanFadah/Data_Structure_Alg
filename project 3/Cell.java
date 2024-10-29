/*
File: Cell.java
Author: Ghailan Fadah
Date: 09/25/2021
Description: creates a cell class holds a value, locked, row, and column attributes"
*/

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Cell {

    // creates attributes for cell
    private boolean lock;
    private int value;
    private int row;
    private int column;

    // default constructor. creates a cell that is locked
    public Cell() {
        this.value = 0;
        this.row = 0;
        this.column = 0;
        this.lock = false;

    }

    // constructor
    public Cell(int row, int col, int value) {
        this.row = row;
        this.column = col;
        this.value = value;
        this.lock = false;
    }

    // constructor
    public Cell(int row, int col, int value, boolean locked) {
        this.row = row;
        this.column = col;
        this.value = value;
        this.lock = locked;
    }

    // returns the row
    public int getRow() {
        return this.row;
    }

    // returns the column
    public int getCol() {
        return this.column;
    }

    // returns the value
    public int getValue() {
        return this.value;
    }

    // sets new value
    public void setValue(int newval) {
        this.value = newval;
    }

    // returns if locked or not
    public boolean isLocked() {
        return this.lock;
    }

    // sets locked state
    public void setLocked(boolean lock) {
        this.lock = lock;
    }

    // makes a cell like the other
    public Cell cloneCell() {
        Cell temCell = new Cell(this.row, this.column, this.value, this.lock);

        return temCell;

    }

    // draw method
    public void draw(Graphics g, int x0, int y0, int scale) {

        // creates 3 random floats
        Random rand = new Random();
        float r = rand.nextFloat();
        float gr = rand.nextFloat();
        float b = rand.nextFloat();

        // uses the 3 random numbers to create a new color
        Color randomColor = new Color(r, gr, b);

        // sets the color and draws a rectangle
        g.setColor(randomColor);
        g.drawRect(x0 + this.getCol() * scale, y0 + this.getRow() * scale, scale, scale);

        // creates a char array of size 2
        char[] charArray = { (char) ('0' + this.value) };

        // draws the value of the cell if it is not equal to 0
        if (this.value != 0) {

            g.drawChars(charArray, 0, 1, x0 + this.getCol() * scale + 13, y0 + this.getRow() * scale + 20);

        }

    }

    // string method prints the value of each cell
    public String toString() {

        return String.valueOf(this.value);
    }

}