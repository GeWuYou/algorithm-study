package com.gewuyou.algorithm.problem;

/**
 * 75. 颜色分类
 *
 * @author gewuyou
 * @since 2024-04-21 下午1:51:39
 */
public class ColorClassification {
    public void sortColors(int[] nums) {
        // 左指针
        int left = 0;
        // 右指针
        int right = nums.length - 1;
        // 数组索引
        int i = 0;
        while (i <= right) {
            // 如果当前元素是 0，则交换到数组最前方
            if (nums[i] == 0) {
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
                i++;
            }
            // 如果当前元素是 2，则交换到数组最后方
            else if (nums[i] == 2) {
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
            }
            // 如果当前元素是 1，则不做任何操作
            else {
                i++;
            }
        }
    }
}
