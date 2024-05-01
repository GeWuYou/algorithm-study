package com.gewuyou.algorithm.dailyquestion;

/**
 * 213. 打家劫舍 II
 *
 * @author gewuyou
 * @since 2024-05-22 下午1:07:03
 */
public class Rob_II {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
       return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }


    private int rob(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
