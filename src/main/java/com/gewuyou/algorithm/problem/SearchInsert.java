package com.gewuyou.algorithm.problem;

/**
 * 搜索插入位置
 *
 * @author gewuyou
 * @since 2024-04-05 下午2:25:21
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        // 排除极端位置
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        if (target < nums[0]) {
            return 0;
        }
        // 定义左右指针
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // 计算中间位置
            int mid = (left + right) / 2;
            // 如果中间的数小于目标数则将左指针更新到中间索引+1位置
            if (target > nums[mid]) {
                left = mid + 1;
            }
            // 如果中间的数大于目标数则将右指针更新到中间索引-1位置
            else if (target < nums[mid]) {
                right = mid - 1;
            }
            // 如果中间的数等于目标数则返回中间索引
            else {
                return mid;
            }
        }
        // 如果循环结束还未返回则表示出现left>right，返回left 因为nums[right]<target<nums[left]
        // 所以返回left
        return left;
    }
}
