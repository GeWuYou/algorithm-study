package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 连续子数组的最大和
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaximumSumOfConsecutiveSubarrays
 * @apiNote </br>
 * @since 2023/1/27 11:44
 */
public class MaximumSumOfConsecutiveSubarrays {
    // public int maxSubArray(int[] nums) {
    //     if (nums.length == 1) {
    //         return nums[0];
    //     }
    //     int max = nums[0];
    //     for (int i = 1; i < nums.length; i++) {
    //         // dp(i) = Math.max(dp(i-1)+nums[i],nums[i])
    //         nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
    //         if (max < nums[i]) {
    //             max = nums[i];
    //         }
    //     }
    //     return max;
    // }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum = nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
