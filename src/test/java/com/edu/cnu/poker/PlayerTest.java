package com.edu.cnu.poker;

/**
 * Created by uuani on 2017. 4. 27..
 */
public class PlayerTest {

    private Player player1;
    private Player player2;

    private void playGame(int numOfRound){
        for(int i = 1; i <= numOfRound; i++){
            System.out.println("Round " + i + ":");
            playRound(i);
        }
        if(player1.Score() > player2.Score()){
            System.out.println("Player 1 wins.");
        }
        else if(player1.Score() < player2.Score()){
            System.out.println("Player 2 wins.");
        }
        else{
            System.out.println("Draw.");
        }
    }
    private void playRound(int numOfRound){
        System.out.println("Player 1:");
        player1.takeTurn(numOfRound);
        System.out.println("Player 2:");
        player2.takeTurn(numOfRound);
        System.out.println("Player 1 score : " + player1.Score());
        System.out.println("Player 2 score : " + player2.Score());
    }

}
