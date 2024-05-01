package com.gewuyou.algorithm.problem;

/**
 * 908. 最小差值 I
 *
 * @author gewuyou
 * @since 2024-05-08 下午12:10:01
 */
public class MinimumDifferenceI {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return Math.max(0, max - min - 2 * k);
    }
}
