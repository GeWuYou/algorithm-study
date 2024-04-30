package com.gewuyou.algorithm.problem;

/**
 * 33. 搜索旋转排序数组
 *
 * @author gewuyou
 * @since 2024-04-11 下午8:23:05
 */
public class SearchForARotationallySortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int left =0,right = n-1;
        while (left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[left]<=nums[mid]){
                if(nums[left]<=target&&nums[mid]>target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if(nums[mid]<target&&nums[right]>=target){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

}
