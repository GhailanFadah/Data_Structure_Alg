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
    private ArrayList<Vertex> list;
  


    // constructor
    public Landscape(int w, int h) {

        this.width = w;
        this.height = h;

        list = new ArrayList<>();

    }

    // getter for the height field
    public int getHeight() {
        return this.height;
    }


    // getter for the width field
    public int getWidth() {
        return this.width;
    }


    public void draw(Graphics g, int scale) {

        // for each loop
        for (Vertex v : list) {
            v.draw(g, scale);
        }
    }


}