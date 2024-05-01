package com.gewuyou.algorithm.dailyquestion;

/**
 * 152. 乘积最大子数组
 *
 * @author gewuyou
 * @since 2024-05-13 下午3:57:53
 */
public class LargestSubarrayOfProducts {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 最终结果
        int maxProduct = nums[0];
        // 当前最大乘积
        int currentMax = nums[0];
        // 当前最小乘积
        int currentMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currentMax;
                currentMax = currentMin;
                currentMin = temp;
            }
            currentMax = Math.max(nums[i], currentMax * nums[i]);
            currentMin = Math.min(nums[i], currentMin * nums[i]);
            maxProduct = Math.max(maxProduct, currentMax);
        }
        return maxProduct;
    }

}
