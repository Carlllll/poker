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
원페어 - 같은 숫자 2개
투페어 - 같은 숫자 2개 + 2개
트리플 - 같은 숫자 3개
스트레이트 - 연속숫자 5개
백스트레이트 - A, 2, 3, 4, 5
마운틴 - 10, J, Q, K, A
플러쉬 - 같은 무늬 5개
풀하우스 - 같은 숫자 3개 + 2개
포카드 - 같은 숫자 4개
스트레이트플러쉬 - 연속 숫자 5개 + 같은 무늬
백스트레이트플러쉬 - A, 2, 3, 4, 5 + 같은 무늬
로얄스트레이트플러쉬 - 10, J, Q, K, A + 같은 무늬
 */
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
}