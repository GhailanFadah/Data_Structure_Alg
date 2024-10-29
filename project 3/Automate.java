/*
File: Automate.java
Author: Ghailan Fadah
Date: 10/10/2021
Description: runs a statistical analysis on the game Sudoku
*/

import java.util.ArrayList;


public class Automate{
    static ArrayList<Long> array;
    public static void main(String [] args){

        // checks the user gives atleast 2 arguments
        if(args.length < 1){
            System.out.print("Usage: program requires atleast 2 arguments" + '\n'
                            + "argument 0: the number of trials to run" + '\n'
                            + "argument 1: the number of locked cells in the intial state" + '\n');
                           
            return;
        }

        // creates and array list 
        array = new ArrayList<Long>();

        // creates variables
        int validSolution = 0;
        int noSolution = 0;

        // lets the user control the number of trails and number of locked cells 
        int trials = Integer.parseInt(args[0]);
        int lockedNums = Integer.parseInt(args[1]);
      
        // loop contols how many trials to run
        for(int i =0; i < trials; i++){
            
            // creates a sudoku game
            Sudoku sudoku = new Sudoku(lockedNums);
    
            // times how long it takes to solve and adds that number to the arrayList
            long startTime = System.nanoTime();
            sudoku.solve(0);
            long endTime = System.nanoTime();
            long elapsedTime = (endTime - startTime);
            array.add(elapsedTime);
    
            // adds one to each variable depending if the board was solved or not
            if(sudoku.board.validSolution()){
                validSolution++;
                
            }else{
                noSolution++;
            }
        }

        // finds the total of the time it took to complete all the trials
        long total = 0;
        for(int i = 0; i < array.size(); i++){
             total = array.get(i);
            total++;

        }

        //finds the average 
       long average = total / trials;

        

        System.out.println("Number of trials: " + trials + '\n' + "Number of locked cells: " + lockedNums);
        System.out.println("Number of valid solutions: " + validSolution);
        System.out.println("Number of invalid solutions: " + noSolution);
        System.out.println("The average amount taken to solve each board (micros): " + average);
        System.out.print("A list of each time taken to solve each board:" + array);
    }


 


   
}