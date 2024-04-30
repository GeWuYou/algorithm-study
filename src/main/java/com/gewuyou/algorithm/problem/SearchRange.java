package com.gewuyou.algorithm.problem;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author gewuyou
 * @since 2024-04-12 下午2:17:50
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            }
            if (nums[mid] == target) {
                l = mid;
                r = mid;
                while (l > 0 && nums[l] == target) {
                    l--;
                }
                while (r < n - 1 && nums[r] == target) {
                    r++;
                }
                if (nums[l] != target) {
                    l++;
                }
                if (nums[r] != target) {
                    r--;
                }
                return new int[]{l, r};
            }
        }
        return new int[]{-1, -1};
    }
}
