/*
File: Deck.java
Author: Ghailan Fadah
Date: 09/13/2021
*/

import java.util.ArrayList;
import java.util.Random;

public class Deck{

    private static ArrayList<Card> deck;
    private static ArrayList<Card> deck2;
    Random ran = new Random();

    // default constructor
    public Deck(){
        deck = new ArrayList<Card>();
        this.build();
        

    }

    // builds a deck with 52 cards and their values 
    public void build(){
        deck = new ArrayList<Card>();

        // adds 4 card of each value 2-9 and 11
        for(int x = 0; x < 4; x++){
            Card myCard = new Card(11);
            deck.add(myCard);

            for(int i = 2; i < 10; i++){
                Card myCard1Card = new Card(i);
                deck.add(myCard1Card);
            }
        }

        // adds 16 cards with value 10
        for(int y = 0; y < 16; y++){
            Card myCard2 = new Card(10);
            deck.add(myCard2);
        }
    }

    // returns the size of the deck as an int
    public int size(){
        return deck.size();
    }

    //returns the card at index 0 and removes it from the deck
    public Card deal(){    
        
        return deck.remove(0);

    }

    // shuffles the  deck by creating an empty deck and adding the old cards to 
    // it randomly then assigning that list back to deck
    public void shuffle(){
        deck2 = new ArrayList<Card>();
        
        for(int i = deck.size() - 1; i >= 0; i--){
            Card cardRemoved = deck.remove(ran.nextInt(deck.size()));
            deck2.add(cardRemoved);
        

        }

        deck = deck2;    // doesn't clear out deck2 atm
    
    }

    // returns the String "deckOrder" which prints out the cards in the deck
    public String toString(){

        String deckOrder = "cards : ";

        for(int i = 0; i < deck.size(); i++){
            deckOrder += deck.get(i).toString() + ',';

        }

       return deckOrder;
    }

    public static void main(String [] args){
        // test code
        //Deck myDeck = new Deck();
        // System.out.println(myDeck);
        // myDeck.deal();
        // System.out.println(myDeck);
        // System.out.println(myDeck.deal());
        // myDeck.shuffle();
        // //System.out.println(deck2);
        // System.out.println(myDeck);



    }

}