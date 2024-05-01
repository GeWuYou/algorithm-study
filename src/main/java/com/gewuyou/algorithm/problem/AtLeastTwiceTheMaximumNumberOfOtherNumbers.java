package com.gewuyou.algorithm.problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 747. 至少是其他数字两倍的最大数
 *
 * @author gewuyou
 * @since 2024-05-01 上午11:26:29
 */
public class AtLeastTwiceTheMaximumNumberOfOtherNumbers {
    public int dominantIndex(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int secondMax = nums[nums.length - 2];
        return max >= 2 * secondMax ? map.get(max) : -1;
    }
}
