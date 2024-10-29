/*
File: Simulation.java
Author: Ghailan Fadah
Date: 09/13/2021
*/

public class Simulation {

    
    public static void main(String [] args){
        Blackjack blackjack = new Blackjack(26);

        // creates variables to hold data
        double playerWins = 0;
        double dealerWins = 0;
        double ties = 0;

        // loop that plays 100 games of blackjack
        for( int i = 0; i < 1000; i++){
            blackjack.game(false);
            
            if(blackjack.game(false) == 1){
                playerWins += 1;
            }

            if(blackjack.game(false) == -1){
                dealerWins += 1;
            }

            if(blackjack.game(false) == 0){
                ties += 1;
            }
        
        }
        // prints out the data
        System.out.println("number of games won by player:" + playerWins + "\n percent:" + playerWins / 1000.0 * 100.0 +'%');
        System.out.println("number of games won by dealer:" + dealerWins + "\n percent:" + dealerWins / 1000.0 * 100.0 +'%');
        System.out.println("number of games that are a tie:" + ties + "\n percent:" + ties / 1000.0 * 100.0 +'%');
        
    }
    
}
