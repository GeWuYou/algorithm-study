package com.gewuyou.algorithm.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 506. 相对名次
 *
 * @author gewuyou
 * @since 2024-04-20 上午8:45:47
 */
public class RelativeRanking {
    public String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        int n = score.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }
        Arrays.sort(score);
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                result[map.get(score[i])] = "Gold Medal";
            } else if (i == n - 2) {
                result[map.get(score[i])] = "Silver Medal";
            } else if (i == n - 3) {
                result[map.get(score[i])] = "Bronze Medal";
            } else {
                result[map.get(score[i])] = (n - i ) + "";
            }
        }
        return result;
    }
}
