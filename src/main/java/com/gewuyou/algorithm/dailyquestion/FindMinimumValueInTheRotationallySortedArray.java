package com.gewuyou.algorithm.dailyquestion;

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * @author gewuyou
 * @since 2024-05-13 下午4:36:59
 */
public class FindMinimumValueInTheRotationallySortedArray {
    public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                // 如果中点大于右端点则最小值在右边
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                }
                // 如果中点小于右端点则最小值在左边或者就是它本身
                else {
                    right = mid;
                }
            }
            return nums[left];
    }
}
