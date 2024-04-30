package com.gewuyou.algorithm.dailyquestion;

/**
 * 锯齿数组
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName AJaggedArray
 * @apiNote </br>
 * @since 2023/2/27 12:56
 */
public class AJaggedArray {
    public int movesToMakeZigzag(int[] nums) {
        return Math.min(movesToMakeZigzag(nums, 0), movesToMakeZigzag(nums, 1));
    }

    public int movesToMakeZigzag(int[] nums, int index) {
        int result = 0;
        for (int i = index; i < nums.length; i += 2) {
            int temp = 0;
            // 判断左边
            if (i - 1 >= 0) {
                temp = Math.max(temp, nums[i] - nums[i - 1] + 1);
            }
            if (i + 1 < nums.length) {
                temp = Math.min(temp, nums[i] - nums[i + 1] + 1);
            }
            result+=temp;
        }
        return result;
    }

}
