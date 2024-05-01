package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 2965. 找出缺失和重复的数字
 *
 * @author gewuyou
 * @since 2024-05-31 下午12:40:10
 */
public class FindOutTheMissingAndDuplicateNumbers {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int m = grid[0].length;
        result[1] = 1;
        for (int[] e : grid) {
            for (int j = 0; j < m; j++) {
                Integer mapOrDefault = map.getOrDefault(e[j], 0);
                if (mapOrDefault == 0) {
                    map.put(e[j], 1);
                } else {
                    result[0] = e[j];
                }
            }
        }
        while (map.containsKey(result[1])){
            result[1]++;
        }
        return result;
    }
}
