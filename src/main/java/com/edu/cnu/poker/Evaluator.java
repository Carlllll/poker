package com.edu.cnu.poker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cse on 2017-04-17.
 */
public class Evaluator {
    public String evaluate(List<Card> cardList) {
        Map<Suit, Integer> tempMap_suit = new HashMap<Suit, Integer>();
        Map<Integer, Integer> tempMap_rank = new HashMap<Integer, Integer>();

        for (Card card : cardList) {
            if (tempMap_suit.containsKey(card.getSuit())) {
                Integer count_suit = tempMap_suit.get(card.getSuit());
                count_suit = new Integer(count_suit.intValue() + 1);
                tempMap_suit.put(card.getSuit(), count_suit);
            } else {
                tempMap_suit.put(card.getSuit(), new Integer(1));
            }
        }

        for (Card card : cardList) {
            if (tempMap_rank.containsKey(card.getRank())) {
                Integer count_rank = tempMap_rank.get(card.getRank());
                count_rank = new Integer(count_rank.intValue() + 1);
                tempMap_rank.put(card.getRank(), count_rank);
            } else {
                tempMap_rank.put(card.getRank(), new Integer(1));
            }
        }

        for (Suit key : tempMap_suit.keySet()) {
            if (tempMap_suit.get(key) == 5) {
                return "FLUSH";
            }
        }

        for (Integer key : tempMap_rank.keySet()) {
            if (tempMap_rank.get(key) == 3) {
                return "TRIPLE";
            }
            else if (tempMap_rank.get(key) == 2) {
                return "ONEPAIR";
            }
        }
        return "NOTHING";
    }
}
