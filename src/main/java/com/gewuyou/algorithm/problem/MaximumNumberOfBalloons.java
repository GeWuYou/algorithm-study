package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1189. “气球” 的最大数量
 *
 * @author gewuyou
 * @since 2024-05-19 上午10:22:31
 */
public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>(Map.of('b', 0, 'a', 0, 'l', 0, 'o', 0, 'n', 0));
        for (char c : text.toCharArray()) {
            if (c == 'b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        // 根据短板效应找出最少出现的字母
        int min = Integer.MAX_VALUE;
        for (char c : map.keySet()) {
            if (c == 'l'|| c == 'o') {
                min = Math.min(min, map.getOrDefault(c, 0) / 2);
            } else {
                min = Math.min(min, map.getOrDefault(c, 0));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MaximumNumberOfBalloons solution = new MaximumNumberOfBalloons();
        String text = "lloo";
        int result = solution.maxNumberOfBalloons(text);
        System.out.println(result);
    }
}
