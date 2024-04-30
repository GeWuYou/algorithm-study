package com.gewuyou.algorithm.problem;

/**
 * 303. 区域和检索 - 数组不可变
 *
 * @author gewuyou
 * @since 2024-04-11 下午2:51:03
 */
public class NumArray {
    private final int[] dp;

    public NumArray(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return dp[right + 1] - dp[left];
    }
}
