package com.gewuyou.algorithm.dailyquestion;

/**
 * 377. 组合总和 Ⅳ
 *
 * @author gewuyou
 * @since 2024-04-22 上午9:43:53
 */
public class CombinedSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }



    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(new CombinedSumIV().combinationSum4(nums, target));
    }
}
