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
    public void playGame() {
            System.out.println("Round " + 1 + ":");
            playRound();
            if (player1.Score()> player2.Score()) {
                System.out.println("Player 1 wins.");
            } else if (player1.Score() < player2.Score()) {
                System.out.println("Player 2 wins.");
            } else {
                System.out.println("Draw.");
            }
        }

    @Test
    public void playRound(){
        System.out.println("Player 1:");
       // player1.takeTurn();
        System.out.println("Player 2:");
  //      player2.takeTurn();
//        System.out.println("Player 1 score : " + player1.Score());
  //      System.out.println("Player 2 score : " + player2.Score());
    }

}