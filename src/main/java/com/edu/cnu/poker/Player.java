package com.edu.cnu.poker;

import java.io.*;

//player 클래스는 점수를 가지고 있고,
// round 변수를 가지고 있어서 라운드마다 점수를 집계한 뒤,
// 승자를 결정한다
// round를 주고 받으려면 플레이어가 turn을 주고 받으면서 각자의 게임을 진행해야한다 (taketurn 함수)
// DrawAgain 함수를 이용하여 게임을 계속 이어가고 싶은경우 true, 그만 하겠다 하면 falsea로 리턴하게 해준다
//
//
public class Player {

	private final Card card;
	private final int score;
	private int Score = 0;
	private int Sumofscore = 0;
	private int RoundCount = 0;

	public Player(BufferedReader buf, Card card){ // 하나이상의 플레이어를 정의하기 위한 player 클래스
		this.card = card;
		this.score = 0;
    }

	private boolean DrawAgain(BufferedReader buf){
		System.out.print("Do you want more game? (y/n): ");
		try {
			String input = buf.readLine();
			if(input.equals("n"))
			    return false;
			else if(input.equals("y"))
			    return true;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	public int Score(){
		this.Score += this.Sumofscore;
		return this.Score;
	}

	public void takeTurn(int Round){

	}

}
