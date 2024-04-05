package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 628. 三个数的最大乘积
 *
 * @author gewuyou
 * @since 2024-04-25 下午2:34:33
 */
public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        // 找出最大的三个数
        int n1 = nums[nums.length - 1];
        int n2 = nums[nums.length - 2];
        int n3 = nums[nums.length - 3];
        // 找出最小的两个数
        int n4 = nums[0];
        int n5 = nums[1];
        // 最大乘积
        return Math.max(n1 * n2 * n3, n1 * n5 * n4);
    }
}
