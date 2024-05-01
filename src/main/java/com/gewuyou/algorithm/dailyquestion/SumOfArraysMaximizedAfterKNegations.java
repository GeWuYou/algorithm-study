package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 1005. K 次取反后最大化的数组和
 *
 * @author gewuyou
 * @since 2024-05-13 下午2:28:19
 */
public class SumOfArraysMaximizedAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length;
        // 先将数组排序
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        // 判断数组中是否存在负数
        if (nums[0] < 0) {
            // 如果存在负数，则从前向后取反
            for (int i = 0; i < k; i++) {
                // 判断k是否超过数组长度
                if (i == n) {
                    if (((k - i) & 1) == 1) {
                        nums[minIndex] = -nums[minIndex];
                    }
                    break;
                }
                if (nums[i] < 0) {
                    nums[i] = -nums[i];
                    if (nums[i] < min) {
                        min = nums[i];
                        minIndex = i;
                    }
                }
                // 如果负数已经取反完毕，判断剩余次数是否为奇数，如果是奇数，判断负数取正后的最小值与正数最小值谁小，小者取反,偶数则不操作
                else {
                    if (((k - i) & 1) == 1) {
                        if (min < nums[i]) {
                            nums[minIndex] = -nums[minIndex];
                        } else {
                            nums[i] = -nums[i];
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            // 如果不存在负数，则判断k是否为奇数，如果是奇数，则取反最小值，如果是偶数，则不操作
            if ((k & 1) == 1) {
                nums[0] = -nums[0];
            }
        }
        // 计算和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -2, -3};
        int k = 4;
        System.out.println(new SumOfArraysMaximizedAfterKNegations().largestSumAfterKNegations(nums, k));
    }
}
