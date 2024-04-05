package com.gewuyou.algorithm.problem;

/**
 * 643. 子数组最大平均数 I
 *
 * @author gewuyou
 * @since 2024-04-26 上午9:27:59
 */
public class MaximumAverageOfTheSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        double max = Double.NEGATIVE_INFINITY;
        double sum = 0;
        int n = nums.length;
        // 初始化和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = Math.max(max, sum);
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max / k;
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        int k = 1;
        MaximumAverageOfTheSubarrayI solution = new MaximumAverageOfTheSubarrayI();
        double result = solution.findMaxAverage(nums, k);
        System.out.println(result);
    }
}
