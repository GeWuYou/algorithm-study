package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 2779. 数组的最大美丽值
 *
 * @author gewuyou
 * @since 2024-06-15 下午3:16:27
 */
public class MaximumBeautyValueOfTheArray {
    public int maximumBeauty(int[] nums, int k) {
       Arrays.sort(nums);
       int ans = 0;
       int left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right]-nums[left] > k*2) {
                left++;
            }
            ans = Math.max(ans,right-left+1);
        }
        return ans;
    }
}
