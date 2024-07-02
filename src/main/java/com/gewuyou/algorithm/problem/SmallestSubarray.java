package com.gewuyou.algorithm.problem;

/**
 * 209. 长度最小的子数组
 *
 * @author gewuyou
 * @since 2024-05-21 下午7:31:15
 */
public class SmallestSubarray {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        for (int left = 0, right = 0; left < n; left++) {
            while (sum < target && right < n) {
                sum += nums[right];
                right++;
            }
            if (sum >= target) {
                min = Math.min(min, right - left);
            }
            sum -= nums[left];
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int target =11;
        int res = new SmallestSubarray().minSubArrayLen(target, nums);
        System.out.println(res);
    }
}
