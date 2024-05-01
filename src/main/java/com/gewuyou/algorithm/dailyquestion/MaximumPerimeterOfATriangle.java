package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 *
 * @author gewuyou
 * @since 2024-05-11 下午12:48:33
 */
public class MaximumPerimeterOfATriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            // 两边之和大于第三边
            if(nums[i-1] + nums[i-2] > nums[i]){
                return nums[i] + nums[i-1] + nums[i-2];
            }
        }
        return 0;
    }
}
