package com.gewuyou.algorithm.dailyquestion;

/**
 * 分隔数组以得到最大和
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SeparateTheArraysToGetTheMaximumSum
 * @apiNote </br>
 * @since 2023/4/19 10:00
 */
public class SeparateTheArraysToGetTheMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int length = arr.length;
        int[] dp = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            int maxValue = arr[i - 1];
            for (int j = i - 1; j >= 0 && j >= i - k; j--) {
                dp[i] = Math.max(dp[i], dp[j] + maxValue * (i - j));
                if (j > 0) {
                    maxValue = Math.max(maxValue, arr[j - 1]);
                }
            }
        }
        return dp[length];
    }
}
