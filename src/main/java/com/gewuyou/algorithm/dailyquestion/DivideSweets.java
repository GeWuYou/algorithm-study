package com.gewuyou.algorithm.dailyquestion;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 *
 * @author gewuyou
 * @since 2024-06-02 下午12:11:39
 */
public class DivideSweets {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> set = new HashSet<>();
        for (int j : candyType) {
            set.add(j);
        }
        return Math.min(n / 2, set.size());
    }
}
