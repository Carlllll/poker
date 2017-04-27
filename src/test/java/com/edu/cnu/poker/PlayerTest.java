package com.edu.cnu.poker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by uuani on 2017. 4. 27..
 */
public class PlayerTest {


    private Player player1;
    private Player player2;


    @Test
    public void playGame(){
        for(int i = 1; i <= 3; i++){
            System.out.println("Round " + i + ":");
            playRound();
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
    @Test
    public void playRound(){
        System.out.println("Player 1:");
        player1.takeTurn(3);
        System.out.println("Player 2:");
        player2.takeTurn(3);
        System.out.println("Player 1 score : " + player1.Score());
        System.out.println("Player 2 score : " + player2.Score());
    }

}
