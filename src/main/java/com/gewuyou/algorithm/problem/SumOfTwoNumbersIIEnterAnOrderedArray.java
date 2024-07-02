package com.gewuyou.algorithm.problem;

/**
 * 167. 两数之和 II - 输入有序数组
 *
 * @author gewuyou
 * @since 2024-07-28 上午9:59:46
 */
public class SumOfTwoNumbersIIEnterAnOrderedArray {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }
}
