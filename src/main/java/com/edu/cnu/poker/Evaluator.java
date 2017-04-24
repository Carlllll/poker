package com.edu.cnu.poker;

import java.util.*;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    int num_two = 0;
    int num_three = 0;
    int num_four = 0;

    public String evaluate(List<Card> cardList) {


        Collections.sort(cardList);
        Collections.reverse(cardList);

        Map<Suit, Integer> tempMap_suit = new HashMap<Suit, Integer>();
        Map<Integer, Integer> tempMap_rank = new HashMap<Integer, Integer>();

        countSameSuit(cardList, tempMap_suit);
        countSameRank(cardList, tempMap_rank);

        countPairs(tempMap_rank);


        for (Suit key : tempMap_suit.keySet()) {
            if (tempMap_suit.get(key) == 5) {
                if (isSuccessive(cardList)){
                    if(cardList.get(0).getRank()==13){
                        return "ROYALSTRAIGHTFLUSH";
                    }
                    return "STRAIGHTFLUSH";
                }
                return "FLUSH";
            }
        }

        if(isSuccessive(cardList)){
            return "STRAIGHT";
        }

        if (num_four == 1) {
            return "FOUROFAKIND";
        } else {
            if (num_three == 1) {
                if (num_two == 1) {
                    return "FULLHOUSE";
                }
                return "THREEOFAKIND";
            } else if (num_two == 2) {
                return "TWOPAIR";
            } else if (num_two == 1) {
                return "ONEPAIR";
            } else {
                return "NOTHING";
            }
        }
    }

    private void countPairs(Map<Integer, Integer> tempMap_rank) {
        for (Integer key : tempMap_rank.keySet()) {
            if (tempMap_rank.get(key) == 4) {
                num_four++;
            } else if (tempMap_rank.get(key) == 3) {
                num_three++;
            } else if (tempMap_rank.get(key) == 2) {
                num_two++;
            }
        }
    }

    private void countSameRank(List<Card> cardList, Map<Integer, Integer> tempMap_rank) {
        for (Card card : cardList) {
            if (tempMap_rank.containsKey(card.getRank())) {
                Integer count_rank = tempMap_rank.get(card.getRank());
                count_rank = new Integer(count_rank.intValue() + 1);
                tempMap_rank.put(card.getRank(), count_rank);
            } else {
                tempMap_rank.put(card.getRank(), new Integer(1));
            }
        }
    }

    private void countSameSuit(List<Card> cardList, Map<Suit, Integer> tempMap_suit) {
        for (Card card : cardList) {
            if (tempMap_suit.containsKey(card.getSuit())) {
                Integer count_suit = tempMap_suit.get(card.getSuit());
                count_suit = new Integer(count_suit.intValue() + 1);
                tempMap_suit.put(card.getSuit(), count_suit);
            } else {
                tempMap_suit.put(card.getSuit(), new Integer(1));
            }
        }
    }

    private boolean isSuccessive(List<Card> cardList) {
        int i = 0;
        if(cardList.get(i).getRank()==0){
            cardList.get(i).setRank(14);
        }
        while(cardList.get(i).getRank() - cardList.get(i+1).getRank() == 1 && i < 3){
            i++;
        }

        if (i == 3) {
            return true;
        } else {
            return false;
        }
    }

}
