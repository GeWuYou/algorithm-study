package com.gewuyou.algorithm.problem;

/**
 * 674. 最长连续递增序列
 *
 * @author gewuyou
 * @since 2024-04-27 下午1:43:17
 */
public class LongestContinuousIncrementSequence {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int left = 0;
        int right = 1;
        int n = nums.length;
        while (right < n) {
            if (nums[right] <= nums[right - 1]) {
                max = Math.max(max, right - left);
                left = right;
            }
            right++;
        }
        return Math.max(max, right - left);
    }
}
