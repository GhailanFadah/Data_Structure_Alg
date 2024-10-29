/*
File: Hand.java
Author: Ghailan Fadah
Date: 09/13/2021
*/

import java.util.ArrayList;


public class Hand {

    private ArrayList<Card> hand;

    // default constructor
    public Hand(){
        hand = new ArrayList<Card>();

    }

    // clears the arrayList
    public void reset(){
        hand.clear();
    }

    // adds an object card to the hand arrayList
    public void add(Card card){
        if(this.getTotalValue() + 11 > 21){
            card.changeAceValue(card);
        }
        hand.add(card);
    }

    // returns the size of the arrayList as an int
    public int size(){
        return hand.size();
    }

    // returns the card at the specific i index
    public Card getCard(int i){
        return hand.get(i);

    }

    // returns the total value of the arrayList
    public int getTotalValue(){
        int sum = 0;
        for(int i = 0; i < hand.size(); i++){

            sum += hand.get(i).getValue(); 
            
        }
        return sum;
    }

    // returns the String "result" which prints out the hand and the its value
     public String toString(){

         String result = "cards : ";

         for(int i = 0; i < hand.size(); i++){
            result += hand.get(i).toString() + ',';
            

         }
         result += "\n Total: ";
         result += this.getTotalValue();


         return result;
     }


    public static void main(String [] args){

        // test code
        //  Card myCard1 = new Card(25);
        //  Card myCard2 = new Card(10);
        //  Card myCard3 = new Card(11);
        //  Hand hand1 = new Hand();
        //   hand1.add(myCard1);
        //   hand1.add(myCard2);
        //   hand1.add(myCard3);
        //  System.out.print(hand1.size());
        //  System.out.print(hand1);
        //  //hand1.reset();
        //  System.out.print(hand1);
        //  System.out.print(hand1.getCard(1));
        //System.out.print(hand1);
        
        
        

        

    }

    
}
