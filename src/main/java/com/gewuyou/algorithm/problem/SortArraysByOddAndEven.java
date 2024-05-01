package com.gewuyou.algorithm.problem;

/**
 * 905. 按奇偶排序数组
 *
 * @author gewuyou
 * @since 2024-05-07 下午7:15:41
 */
public class SortArraysByOddAndEven {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            while ((nums[left] & 1) == 0) {
                left++;
                if (left > n - 1) {
                    return nums;
                }
            }

            while ((nums[right] & 1) == 1) {
                right--;
                if (right < 0) {
                    return nums;
                }
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }
}
