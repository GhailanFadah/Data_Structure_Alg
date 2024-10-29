/*
File: Cell.java
Author: Ghailan Fadah
Date: 09/25/2021
Description: creates a cell class that either holds a state of true "alive" or false "dead"
*/




import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;


public class Cell {

    // creates a boolean field called "state"
    private boolean state;
    

    // default contructor. creates a cell with attribute false "dead"
    public Cell(){
        this.state = false;

    }


    // changes the state of the cell to input boolean
    public Cell(boolean alive){
        this.state = alive;

    }


    // returns the state of the cell 
    public boolean getAlive(){
        return this.state;

    }


    // resets the cell to false "dead"
    public void reset(){
        this.state = false;
    }


    // sets the state of the cell to input boolean
    public void setAlive(boolean alive){
        this.state = alive;

    }


    // the toString method that prints out a 1 if the cell is alive and a 0 if the cell is dead 
    public String toString(){   // Not Working

        if (this.state){
            return "1";
        }

        return "0";
        
    }


    // draws the cells. if the cell is alive it fills it else it only draws it without filling it.
    public void draw(Graphics g, int x, int y, int scale){

        // creates a random object and uses it to create three random numbers between 0-1
        Random rand = new Random();
        float r = rand.nextFloat();
        float gr = rand.nextFloat();
        float b = rand.nextFloat();
        
        // uses the 3 random numbers to create a new color
        Color randomColor = new Color(r, gr, b);

        if(this.state){
            // uses the random color and colors makes a rectangle with it
            g.setColor(randomColor);
            g.fillRect(x, y, 1 * scale, 1 * scale); 

         // if the cell is dead it is not colord but only outlined in dark gray
        }else{

            g.setColor(Color.darkGray);
            g.drawRect(x, y, 1 * scale, 1 * scale);

        }

    }


    // updates the cell to either alive or dead based on its neighbors
    public void updateState(ArrayList<Cell> neighbors){

        // counter for number of alive neigbors
        int counter = 0;

        // goes over the elements of neighbors and adds 1 everytime there is an alive cell
        for( int i = 0; i < neighbors.size(); i++){
            if(neighbors.get(i).getAlive()){
                counter ++;
            }
        }

        // rest of the code in this method are just the rules of the game 
        if(this.getAlive() && counter == 2 || counter == 3){
            this.setAlive(true);
        }

        if(this.getAlive() == false && counter == 3){
            this.setAlive(true);

        }

        if(counter >= 4 || counter < 2){
            this.setAlive(false);
        }


    }
        


    // testing methods
    public static void main(String [] args){
        // Cell myCell = new Cell(false);
        // Cell myCell2 = new Cell(true);
        // Cell myCell3 = new Cell(true);
        // Cell myCell4 = new Cell(true);
        // Cell myCell5 = new Cell(true);
        // Cell myCell6 = new Cell(true);
        // ArrayList<Cell> neighbors = new ArrayList<Cell>();
        // neighbors.add(myCell2);
        // neighbors.add(myCell3);
        // neighbors.add(myCell4);
        // neighbors.add(myCell5);
        // neighbors.add(myCell6);


        // //myCell.getAlive();
        // //myCell.setAlive(true);
        // System.out.println(myCell);
        // myCell.updateState(neighbors);
        // System.out.println(myCell);

    }



}
