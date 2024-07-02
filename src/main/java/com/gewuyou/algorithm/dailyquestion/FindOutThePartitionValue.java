package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 2740. 找出分区值
 *
 * @author gewuyou
 * @since 2024-07-26 上午10:48:00
 */
public class FindOutThePartitionValue {
    public int findValueOfPartition(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i] - nums[i - 1]);
        }
        return min;
    }
}
