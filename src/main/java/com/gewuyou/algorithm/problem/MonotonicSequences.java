package com.gewuyou.algorithm.problem;

/**
 * 896. 单调数列
 *
 * @author gewuyou
 * @since 2024-05-07 下午6:33:50
 */
public class MonotonicSequences {
    public boolean isMonotonic(int[] nums) {
        int prev = nums[0];
        // 递减
        boolean isDecreasing = false;
        // 递增
        boolean isIncreasing = false;
        for (int i = 1; i < nums.length; i++) {
            // 递增
            if (nums[i] > prev) {
                isIncreasing = true;
            }
            // 递减
            else if (nums[i] < prev) {
                isDecreasing = true;
            }
            prev = nums[i];
        }
        // 如果同时递增或者递减则不为单调数列
        return !isIncreasing || !isDecreasing;
    }
}
