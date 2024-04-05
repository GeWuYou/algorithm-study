package com.gewuyou.algorithm.dailyquestion;

/**
 * 正整数和负整数的最大计数
 *
 * @author gewuyou
 * @since 2024-04-09 下午12:52:13
 */
public class MaximumCount {
    public int maximumCount(int[] nums) {
        int pos = 0;
        int neg = 0;
        for (int num : nums) {
            if (num > 0) {
                pos++;// 正整数计数
            } else if (num < 0) {
                neg++;   // 负整数计数
            }
        }
        return Math.min(pos, neg);
    }
}
