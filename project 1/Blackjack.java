/*
File: Blackjack.java
Author: Ghailan Fadah
Date: 09/13/2021
*/

public class Blackjack {
    Hand playerHand = new Hand();
    Hand dealerHand = new Hand();
    Deck deck = new Deck();
    int reshuffleCutOff = 26;

    public Blackjack(int reshuffleCutoff){

    }

    // clears the hands and shuffles the deck if need
    public void reset(){

        playerHand.reset();
        dealerHand.reset();

        // builds a new deck if the cards go below reshuffleCutOff
        if (deck.size() < reshuffleCutOff){
            deck.build();
            deck.shuffle();
        }

    }

    // deals two cards to each player
    public void deal(){
        playerHand.add(deck.deal());
        playerHand.add(deck.deal());
        dealerHand.add(deck.deal());
        dealerHand.add(deck.deal());

    }

    // adds a card to the player until their value is <=16
    // returns false if above 21
    public boolean playerTurn(){

        while(playerHand.getTotalValue() <= 16){
            playerHand.add(deck.deal());
            
        }
        if(playerHand.getTotalValue() > 21){
            return false;

        }else{
            return true;
        }
    }

    // adds a card to the dealer until their value is <=17
    // returns false if above 21
    public boolean dealerTurn(){
        
        while(dealerHand.getTotalValue() <= 17){
            dealerHand.add(deck.deal());
            
        }
        if(dealerHand.getTotalValue() > 21){
            return false;

        }else{
            return true;
        }
    }

    // sets a new value for the shuffle cutoff variable
    public void setReshuffleCutOff(int cutoff){
        reshuffleCutOff = cutoff;

    }

    // gets the reshuffleCutOff int
    public int getReshuffleCutOff(){
        
        return reshuffleCutOff;

    }

    // returns the String "stateOfGame" which prints out the player and dealer hand
    public String toString(){
        String stateOfGame =  "player hand: \n" + playerHand.toString() + 
        "\n dealer hand: \n" + dealerHand.toString();
        return stateOfGame;
    
    }

    public int game(boolean verbose){
        this.reset();
        // creates a String varible that holds are information to be printed out
        String gameStatement = "initial player hand: \n" + playerHand;
        gameStatement += "\n initial dealer hand: \n" + dealerHand;

        // plays game
        this.deal();
        this.playerTurn();
        this.dealerTurn();
        gameStatement += '\n' + toString();

        // if statements decide who won or a tie 
        if(playerTurn() == false){
            gameStatement += "\n Dealer Won!";
            if(verbose == true){
                System.out.println(gameStatement);
            
            }
            
            return -1;
        }

        if(dealerTurn() == false){
            gameStatement += "\n player Won!";
            if(verbose == true){
                System.out.println(gameStatement);
            
            }
            
            return 1;
        }
    
        if(playerHand.getTotalValue() > dealerHand.getTotalValue()){
            gameStatement += "\n Player won!";
            if(verbose == true){
                System.out.println(gameStatement);
            
            }
            
            return 1;
        }
        if( dealerHand.getTotalValue() > playerHand.getTotalValue()){
            gameStatement += "\n Dealer Won!";
            if(verbose == true){
                System.out.println(gameStatement);
            
            }
           
            return -1;
        }

        if(playerHand.getTotalValue() == 21 && playerHand.size() == 2 && dealerHand.size() > 2){
            gameStatement += "\n Player won!";
            if(verbose == true){
                System.out.println(gameStatement);
            
            }
           
            return 1;
        }


        if(dealerHand.getTotalValue() == 21 && dealerHand.size() == 2 && playerHand.size() > 2){
            gameStatement += "\n Dealer Won!";
            if(verbose == true){
                System.out.println(gameStatement);
            
            }
           
            return -1;
        }

        gameStatement += "\n it is a tie!";
        if(verbose == true){
            System.out.println(gameStatement);
        
        }
        
        // if none of the if statements are true then game must be a tie
        return 0;

        
    }




    public static void main(String [] args){
        // test code
        Blackjack blackjack1 = new Blackjack(26);
        blackjack1.game(true);
        blackjack1.game(true);
        blackjack1.game(true);

        // Deck myDeck = new Deck();
        // System.out.println(myDeck);
        // blackjack1.reset();
        // blackjack1.deal();
        // blackjack1.playerTurn();
        // blackjack1.dealerTurn();
        // System.out.println(blackjack1);
        // System.out.println(myDeck);
        // blackjack1.reset();
        // System.out.println(blackjack1);
        // System.out.println(myDeck);
        // blackjack1.deal();
        // blackjack1.playerTurn();
        
    }
}
