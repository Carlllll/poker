package com.edu.cnu.poker;

import java.io.*;

//player 클래스는 점수를 가지고 있고,
// round 변수를 가지고 있어서 라운드마다 점수를 집계한 뒤,
// 승자를 결정한다
// round를 주고 받으려면 플레이어가 turn을 주고 받으면서 각자의 게임을 진행해야한다 (taketurn 함수)
//
//
//
public class Player {

	private final Card card;
	private final int score;
	private int Score = 0;
	private int Sumofscore = 0;
	private int RoundCount = 0;

	public Player(Card card){
		this.card = card;
		this.score = 0;
	}

	public int Score(){
		this.Score += this.Sumofscore;
		return this.Score;
	}

	public void takeTurn(int Round){

	}


}
