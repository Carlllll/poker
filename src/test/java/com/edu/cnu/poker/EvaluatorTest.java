package com.edu.cnu.poker;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by cse on 2017-04-17.
 */
public class EvaluatorTest {
/*
원페어(one pair) - 같은 숫자 2개                                        completed  git
투페어(two pair) - 같은 숫자 2개 + 2개                                   completed  git
트리플(three of a kind) - 같은 숫자 3개                                 completed  git
포카드(four of a kind) - 같은 숫자 4개                                  completed  git
스트레이트(straight) - 연속숫자 5개
플러쉬(flush) - 같은 무늬 5개                                           completed  git
풀하우스(full house) - 같은 숫자 3개 + 2개                                completed  git
스트레이트플러쉬(straight flush)- 연속 숫자 5개 + 같은 무늬
로얄스트레이트플러쉬(royal straight flush) - 10, J, Q, K, A + 같은 무늬
*/
    @Test
    public void RANK가_2개가동일하면_원페어다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(1,Suit.HEARTS),
                new Card(8,Suit.CLUBS),
                new Card(13,Suit.DIAMONDS),
                new Card(2,Suit.HEARTS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("ONEPAIR"));
    }
    @Test
    public void RANK가_2개가동일한게_두개있으면_투페어다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(1,Suit.HEARTS),
                new Card(2,Suit.CLUBS),
                new Card(13,Suit.DIAMONDS),
                new Card(2,Suit.HEARTS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("TWOPAIR"));
    }
    @Test
    public void RANK가_3개가동일하면_트리플이다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(1,Suit.HEARTS),
                new Card(8,Suit.CLUBS),
                new Card(13,Suit.DIAMONDS),
                new Card(1,Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("THREEOFAKIND"));
    }
    @Test
    public void RANK가_4개가동일하면_포카드다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(1,Suit.HEARTS),
                new Card(8,Suit.CLUBS),
                new Card(1,Suit.SPADES),
                new Card(1,Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FOUROFAKIND"));
    }
    @Test
    public void SUIT가_5개가동일하면_플러쉬다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(4,Suit.CLUBS),
                new Card(8,Suit.CLUBS),
                new Card(13,Suit.CLUBS),
                new Card(2,Suit.CLUBS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FLUSH"));
    }
    @Test
    public void RANK가_3개가동일하고_나머지2개가동일하면_풀하우스다() {
        Evaluator evaluator = new Evaluator();
        List<Card> cardList = Arrays.asList(
                new Card(1,Suit.CLUBS),
                new Card(1,Suit.HEARTS),
                new Card(8,Suit.CLUBS),
                new Card(8,Suit.SPADES),
                new Card(1,Suit.DIAMONDS)
        );
        String result = evaluator.evaluate(cardList);
        assertThat(result, is("FULLHOUSE"));
    }
}