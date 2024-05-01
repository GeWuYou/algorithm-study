package com.gewuyou.algorithm.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *
 * @author gewuyou
 * @since 2024-05-06 下午4:42:34
 */
public class LongestContinuousSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxLen = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int len = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
