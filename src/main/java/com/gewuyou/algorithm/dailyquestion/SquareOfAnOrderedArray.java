package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 *
 * @author gewuyou
 * @since 2024-05-11 下午12:56:44
 */
public class SquareOfAnOrderedArray {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
