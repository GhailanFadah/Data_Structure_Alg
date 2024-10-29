/*
File: Card.java
Author: Ghailan Fadah
Date: 09/13/2021
*/


public class Card {
    
    private int value;

    // default constructor
    public Card(){

        value = 0;
    }

    // card value constructor
    public Card(int var){
        value = var;
    }

    // accesser for the card value
    public int getValue(){
        return value;
    }

    public int changeAceValue(Card card){
        if(card.getValue() == 11){
            return value = 1;
        }
        return value;
    }


    // returns the string representation of an object
    public String toString(){

        return Integer.toString(value);   
     }

     public static void main(String [] args){

        // // test code
        // Card mycard1 = new Card(11);
        // Card mycard2 = new Card(10);
        // // System.out.println(mycard1.getValue());
        // // System.out.println(mycard2);
        // System.out.println(mycard1.changeAceValue(mycard1));
        // System.out.println(mycard2.changeAceValue(mycard2));
        
    }

   
}

