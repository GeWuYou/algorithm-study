package com.gewuyou.algorithm.problem;

/**
 * 724. 寻找数组的中心下标
 *
 * @author gewuyou
 * @since 2024-04-30 下午12:28:06
 */
public class LookForTheCenterSubscriptOfTheArray {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
