package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 594. 最长和谐子序列
 *
 * @author gewuyou
 * @since 2024-04-24 下午12:52:15
 */
public class LongestHarmonicSubsequence {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> countMap = new HashMap<>();

        // 计算每个数字的出现次数
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // 遍历数字及其出现次数
        for (int num : countMap.keySet()) {
            if (countMap.containsKey(num + 1)) {
                maxLength = Math.max(maxLength, countMap.get(num) + countMap.get(num + 1));
            }
        }

        return maxLength;
    }
}
