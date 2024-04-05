package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 31. 下一个排列
 *
 * @author gewuyou
 * @since 2024-04-11 下午3:11:58
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, nums.length);
                // 找出i-1后最小且大于它对应的值的数
                for (int j = i; j < nums.length; j++) {
                    if (nums[i - 1] < nums[j]) {
                        swap(nums, j, i - 1);
                        return;
                    }
                }

            }
        }
        Arrays.sort(nums);
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
