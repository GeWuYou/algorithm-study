package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最好的扑克手牌
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TheBestPokerHands
 * @apiNote </br>
 * @since 2023/2/20 9:33
 */
public class TheBestPokerHands {
    public static String bestHand(int[] ranks, char[] suits) {
        Set<Character> charSet = new HashSet<>();
        // 校验花色是否相同
        for (char suit : suits) {
            charSet.add(suit);
        }
        // 同花
        if (charSet.size() == 1) {
            return "Flush";
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int rank : ranks) {
            map.merge(rank, 1, Integer::sum);
        }
        // 判断高牌
        if(map.size() == 5){
            return "High Card";
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            // 判断三条
            if (integerIntegerEntry.getValue() >= 3) {
                return "Three of a Kind";
            }
        }
        // 剩下只可能是对子
        return "Pair";
    }
}
