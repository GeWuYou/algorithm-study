package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 164. 最大间距
 *
 * @author gewuyou
 * @since 2024-05-15 下午1:08:43
 */
public class MaximumSpacing {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }
}
