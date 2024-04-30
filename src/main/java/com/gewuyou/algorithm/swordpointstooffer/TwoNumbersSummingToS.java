package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 和为 s 的两个数字
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TwoNumbersSummingToS
 * @apiNote </br>
 * @since 2023/1/31 9:29
 */
public class TwoNumbersSummingToS {
    public int[] twoSum(int[] nums, int target) {
        // 定义双指针
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                // 如果相等直接返回结果
                return new int[]{nums[start], nums[end]};
            } else if (nums[start] + nums[end] < target) {
                // 如果小于则将更小值处的索引自增
                start++;
            } else {
                // 如果大于则将更大值处的索引自增
                end--;
            }
        }
        return new int[0];
    }
}
