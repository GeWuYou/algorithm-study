package com.gewuyou.algorithm.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 *
 * @author gewuyou
 * @since 2024-04-23 下午6:27:06
 */
public class DivideSweet {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        Set<Integer> set = new HashSet<>();
        for (int j : candyType) {
            set.add(j);
        }
        return Math.min(n / 2, set.size());
    }
}
