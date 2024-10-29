/*
File: Landscape.java
Author: Ghailan Fadah
Date: 09/25/2021
Description: creates a 2D array which is used as the landscape for the cells to decide if they live or die. 
*/

import java.util.ArrayList;
import java.awt.Graphics;

public class Landscape {

    // creates fields needed for the class
    Cell landScape[][];
    int rows;
    int cols;

    // default constructor
    public Landscape(int rows, int cols){
        this.rows = rows;
        this.cols = cols;

        landScape = new Cell[rows][cols];

        // nested for loop adds a cell to each index
        for(int i = 0;i < rows;i++) {
            
            for(int j = 0;j < cols;j++) {
                landScape[i][j] = new Cell();
                
            }
        }

    }


    // method loops over the 2D array and calls resets on each cell
    public void reset(){

        for(int i = 0;i < this.rows;i++) {
            
            for(int j = 0;j < this.cols;j++) {
                landScape[i][j].reset();
                
            }
        }
    }


    // returns the number of rows 
    public int getRows(){
        return this.rows;

    }


    //returns the number of columns 
    public int getCols(){
        return this.cols;

    }


    // returns the cell at position row and column
    public Cell getCell(int row, int col){ 
         Cell cell = landScape[row][col];

        return cell;
        
    }


    // the toString method prints out the grid
    public String toString(){

        // creates a String variable
        String result = "";

        // nested for loop adds each cell to the result variable and places a comma between each one
        // also at the end of each row it creates a new line
        for(int i = 0;i < getRows(); i++) {
            result += "\n";
            for(int j = 0;j < getCols(); j++) {
                 result += landScape[i][j];
                 result += ",";
                
            }
        }

        //returns result 
        return result;
    }


    // gets the neighbors of the cells and returns them as an ArrayList
    public ArrayList<Cell> getNeigbors(int row, int col){

        // creates an ArrayList called neighbors 
        ArrayList<Cell> neighbors = new ArrayList<Cell>();

        // nested for loop and if statment that adds the left, right, above, below, above-corner-right, 
        // above-corner-left, below-corner-right, below-corner-left.
        for(int i = row - 1; i < row + 2; i++){
            for(int j = col - 1; j < col + 2; j++){

                // if statement makes sure the position is valid on the grid and is not itself
                if(i > - 1 && i < this.rows && j > - 1 
                && j < this.cols && !(row == i && col == j)){
                    neighbors.add(landScape[i][j]);
                }
            }
        }

        //returns the arrayList
        return neighbors;
        
    }


    // draws the landscape 
    public void draw(Graphics g, int gridScale){

        // nested for loop goes over all the rows and columns and calls the draw method on each cell at that position
        for(int i = 0;i < getRows(); i++) {
            
            for(int j = 0;j < getCols(); j++) {
                landScape[i][j].draw(g, j * gridScale, i * gridScale, gridScale);
                
            }
        }

    }


    // moves the landscape by one generation based on the rules of the game and each cell's neighbors
    public void advance(){

        // creates a new grid that is the same as orginal 
        Cell temGrid[][] = new Cell[this.rows][this.cols];

        // nested for loop goes over all the indexies, 
        //creates a cell at each index of the new grid,
        //sets the state of each cell in the new grid as the same state in the old grid,
        // updates the cell in the new grid based on the neighbors list from the old grid
        for(int i = 0;i < getRows();i++) {
            
            for(int j = 0;j < getCols();j++) {
                temGrid[i][j] = new Cell();
                temGrid[i][j].setAlive(landScape[i][j].getAlive()); 
                temGrid[i][j].updateState(this.getNeigbors(i, j));
            }
        }
        
        // sets the new grid back to the old grid
        landScape = temGrid;
    }

    // testing methods
    public static void main(String [] args){
        // Landscape scape = new Landscape(5, 5);
        // scape.getCell(2, 2).setAlive(false);
        // scape.getCell(2, 1).setAlive(true);
        // scape.getCell(2, 3).setAlive(true);
        // scape.getCell(1, 2).setAlive(true);
        // scape.getCell(0, 3).setAlive(true);
        // scape.getCell(0, 2).setAlive(true);
        // scape.getCell(1, 0).setAlive(true);
        // scape.getCell(0, 0).setAlive(true);
        // scape.getCell(4, 3).setAlive(true);
    
        // //scape.getNeigbors(2,2);
        // System.out.println(scape);
        // scape.advance();
        // System.out.println(scape);
        
        //System.out.println(scape);
        //System.out.println(scape.getNeigbors(2,2));
        //System.out.println(scape.getNeigbors(1, 3));

    
        //System.out.println(neigbors.size());
        
    
        // System.out.println(scape.getCols());
        // System.out.println(scape.getRows());
        //System.out.println(scape.getNeigbors(2,2));

        // System.out.println(scape.getCell(1,1));
        
        
    }
}

