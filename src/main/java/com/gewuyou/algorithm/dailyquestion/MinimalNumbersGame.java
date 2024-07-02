package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 2974. 最小数字游戏
 *
 * @author gewuyou
 * @since 2024-07-12 上午9:15:17
 */
public class MinimalNumbersGame {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        var n = nums.length;
        for (int i = 0; i < n; i += 2) {
           var tem = nums[i];
            nums[i] = nums[i+1];
            nums[i+1] = tem;
        }
        return nums;
    }
}
