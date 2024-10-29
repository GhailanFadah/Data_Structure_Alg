/*
File: CellStack.java
Author: Ghailan Fadah
Date: 09/25/2021
Description: creates a stack that can hold cells
*/

public class CellStack {

    // creates an array
    private Cell[] myStack;

    private int size;
    private int top;

    // default constructor
    public CellStack() {

        // creates an array with size 10 and sets top to 0
        size = 10;
        this.myStack = new Cell[this.size];
        top = 0;

    }

    
    // constructor that allows the size to be entered
    public CellStack(int max) {
        this.size = max;
        this.myStack = new Cell[max];
        top = 0;

    }


    // push method alllows you to add a cell to the stack
    public void push(Cell c) {

        // checks if the array is full or not
        // if not adds cell to array and adds 1 to top
        if (this.top < this.size) {
            this.myStack[this.top] = c;
            this.top++;

            return;

            // creates an array twice the orginal and copies all the data
            // adds cell and increases top by 1
        } else {

            // creates temporary array
            Cell[] tempArr = new Cell[this.size * 2];

            // copies all data to temp array
            for (int i = 0; i < this.size; i++) {
                tempArr[i] = this.myStack[i];
            }

            this.myStack = tempArr;
            this.size *= 2;

            this.myStack[this.top] = c;
            this.top++;

        }

    }


    // pop method allows you to remove a cell and return it
    public Cell pop() {

        // checks if the stack is empty
        // if not removes the top element and returns it
        if (!(this.top == 0)) {
            Cell topCell = this.myStack[top - 1];
            this.top--;

            return topCell;
        }

        // if empty returns null
        return null;
    }


    // returns the size of the stack
    public int size() {
        return this.top;
    }


    // checks if the stack is empty or not
    public boolean empty() {
        if (this.top == 0) {
            return true;
        }

        return false;
    }

    // used for debugging not part of the lab requirment
    public String toString() {

        String result = "[";

        for (int i = 0; i < this.top; i++) {
            result += this.myStack[i] + ", ";
        }

        return result + "]";
    }

}
