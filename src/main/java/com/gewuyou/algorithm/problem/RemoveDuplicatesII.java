package com.gewuyou.algorithm.problem;

/**
 * 80. 删除有序数组中的重复项 II
 *
 * @author gewuyou
 * @since 2024-04-23 下午7:08:20
 */
public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
