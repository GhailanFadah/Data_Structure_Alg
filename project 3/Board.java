/*
File: Board.java
Author: Ghailan Fadah
Date: 10/07/2021
Description: creates a 2D board that holds a cell at each position
each cell has a value, a row, a column, and a state if it is locked or not
*/

import java.io.*;
import java.awt.Graphics;

public class Board {

  // creates a field that is a grid
  public Cell grid[][];
  public static final int Size = 9;

    // default constructor. Creates a board with a cell at each position
    public Board(){
      grid = new Cell[Size][Size];

      // nested for loop adds a cell to each index
      for(int i = 0;i < Size; i++) {
          
          for(int j = 0;j < Size; j++) {
              grid[i][j] = new Cell();
              
          }
      }
    }


    // returns the number of columns
    public int getCols(){
      return Size;
    }


    // returns the number of rows
    public int getRows(){
      return Size;
    }


    // returns the cell at [r][c]
    public Cell get(int r, int c){

      return this.grid[r][c];
    }


    // returns whether the cell is locked or not
    public boolean isLocked(int r, int c){
      
      return this.grid[r][c].isLocked();
    }


    // returns the number of locked cells 
    public int numLocked(){
      int nums = 0;

      // loops over the grid and checks if each cell is locked. 
      for(int i = 0;i < Size;i++) {
          
        for(int j = 0;j < Size;j++) {

          if(this.grid[i][j].isLocked()){
            nums++;
          }  
        }
      }
      return nums;
    }


    // returns the value of the cell at [r][c]
    public int value(int r, int c){

      return this.grid[r][c].getValue();
    }


    // gives a new value for a cell 
    public void set(int r, int c, int value){
      this.grid[r][c].setValue(value);

      
    }


    // gives a new value and lock state for a cell
    public void set(int r, int c, int value, boolean locked){
      this.grid[r][c].setValue(value);
      this.grid[r][c].setLocked(locked);
      
    }


    // toString method. draws the grid and seprates it to 3x3 grids
    public String toString(){

      // creates a string variable called result
      String result = "";

      //creates counter variables
      int counter = 0;
      int count = 0;

      for(int i = 0;i < Size; i++) {
        result += "\n";
        count++;

        if(count == 4){
          result += "\n";
        } 

        if(count == 7){
          result += "\n";
        } 

        counter = 0;
        for(int j = 0;j < Size; j++) {
          result += grid[i][j]; 
          counter++;
          if(counter == 3){
            result += "   ";
          } 
          if(counter == 6){
            result += "   "; 
          }
        }
      }

      return result;
    }


    // checks if a number is valued at a specific position on the grid
    public boolean validValue(int row, int col, int value){ 

      // variables used for the 3x3 grid check
      int subrow = (row / 3) * 3;
      int endrow = subrow + 3;
      int subcol = (col / 3) * 3;
      int endcol = subcol + 3;

      // makes sure the number is between 1 and 9
      if(value < 1 || value > 9){
        return false;
      }

      // makes sure the number is unique in the row 
      for(int i = 0; i < Size; i++){
        if(this.value(row, i) == value && i != col){
          return false;

        }

      }

      // makes sure the number is unique in the column
      for(int i = 0; i < Size; i++){
        if(this.value(i, col) == value && i != row){
          return false;
        }
      }

      // makes sure the number is unique in the 3*3 grid 
      for(int r = subrow; r < endrow; r++){
        for(int c = subcol; c < endcol; c++){
          if((this.value(r, c) == value && !( row == r && col == c))){
            return false;
          }
        }
      }

        
      return true;
      
    }


    // returns whether the board has a solution or not
    public boolean validSolution(){ 
      
      // nested for loop loops over all the cells
      for(int i = 0;i < Size;i++) {
        
        for(int j = 0;j < Size;j++) {
         
          // check to see if any cell has an invalid value or 0
          if(this.validValue(i, j, this.get(i, j).getValue()) == false || this.grid[i][j].getValue() == 0){
    
            return false;
          }
            
        }
      }
      return true;
    }

    // returns the best cell to check next
    public Cell findBestCell(){

      // nested for loop loops over all the cells 
      for(int i = 0;i < Size;i++) {   
        for(int j = 0;j < Size;j++) {

          // checks that a cell has value of zero
          if(this.grid[i][j].getValue() == 0 && this.grid[i][j].isLocked() != true){

            // loop that goes from 1 to 9
            for(int k = 1; k < 10; k++){

              // checks if any of the values from 1 to 9 are valid for the cell.
              if(this.validValue(i, j, k)){

                // if so, sets cell to that value and returns it
                this.set(i, j, k);
                Cell cell = new Cell(i, j, k);
                return cell;
            
              } 
                
              
            }
            // returns null if no value is found for the cell
            return null;
            
          }
            
        }
      }

      return null;
    }
    
    public boolean read(String filename) {
        try {

          // assign to a variable of type FileReader a new FileReader object, passing filename to the constructor
          FileReader read = new FileReader(filename);
          // assign to a variable of type BufferedReader a new BufferedReader, passing the FileReader variable to the constructor
            BufferedReader buffer = new BufferedReader(read);
          // assign to a variable of type String line the result of calling the readLine method of your BufferedReader object.
            String line = buffer.readLine();
          // start a while loop that loops while line isn't null
          int row = 0;
            while(!(line == null)){
              String [] words;
          

              // assign to an array of type String the result of calling split on the line with the argument "[ ]+"
              words = line.split("[ ]+");
             

              // print the String (line)
              for(int i = 0; i < words.length; i++){
                this.grid[row][i].setValue(Integer.parseInt(words[i]));
                if(this.grid[row][i].getValue() != 0){
                  this.grid[row][i].setLocked(true);

                }
              }
              row++;

              // print the size of the String array (you can use .length)
              //System.out.print(words.length);

              // assign to line the result of calling the readLine method of your BufferedReader object.
              line = buffer.readLine();
            
            }
            // call the close method of the BufferedReader
            buffer.close();
          


            // return true
            //System.out.println(this);
            return true;
        }
        catch(FileNotFoundException ex) {
          System.out.println("Board.read():: unable to open file " + filename );
        }
        catch(IOException ex) {
          System.out.println("Board.read():: error reading file " + filename);
        }
    
        return false;
    }


    // draws each cell with its value
    public void draw(Graphics g, int scale){

      // nested for loop that goes over each place in the grid
        for(int i = 0;i < Size; i++) {
          
          for(int j = 0;j < Size; j++) {
            
            // calls the draw methodfor each cell 
              this.grid[i][j].draw(g, j * 40, i * 40, scale);
              
          }
        }
    
    }

    // rest of code was used for testing 
      public static void main(String [] args){
           Board board = new Board();
      
           board.read(args[0]);
          //board.findBestCell();
          //board.validSolution();
          
          //System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
          // System.out.println("should be true " + board.findBestCell());
           System.out.print(board);
          //System.out.println("should be true " + board.validSolution());

          // System.out.println(board);
          // System.out.println("should be true " + board.validValue(1, 1, 4));
          // System.out.println("should be false " + board.validValue(1, 1, 6));
          // System.out.println("should be true " + board.validValue(1, 8, 2));
          //  System.out.println("should be false " + board.validValue(1, 7, 8));
          // System.out.println("should be true " + board.validValue(8, 5, 4));
          // System.out.println("should be false " + board.validValue(8, 5, 6));
          // System.out.println("should be false " + board.validValue(8, 8, 7));
          // System.out.println("should be false " + board.validValue(8, 8, 8));
          // System.out.println("should be false " + board.validValue(8, 8, 9));
          // System.out.println("should be true " + board.validValue(8, 8, 5));
    
    
          
          // System.out.println(board.getCols());
          // System.out.println(board.getRows());
          // System.out.println(board.isLocked(2, 2));
          // System.out.println(board.get(2, 2));
          // System.out.println(board.getCols());
          // System.out.println(board.numLocked());
          // System.out.println(board.value(2, 2));
          // System.out.println(board.getCols());
          // board.set(2, 2, 2);
          // System.out.println(board.get(2, 2));
          // board.set(2, 2, 2, true);
          // System.out.println(board.get(2, 2));
          // System.out.println(board.numLocked());
          // System.out.println(board.value(2, 2));
          // System.out.println(board.isLocked(2, 2));

        
          
      }
}
