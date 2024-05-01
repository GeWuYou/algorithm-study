package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 209. 长度最小的子数组
 *
 * @author gewuyou
 * @since 2024-05-21 下午7:31:15
 */
public class SmallestSubarray {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int currSum = 0;
        List<Integer> res = new ArrayList<>();
        for (int start = 0, end = 0; start < n; start++) {
            while (currSum < target && end < n) {
                currSum += nums[end];
                end++;
            }
            if (currSum >= target) {
                res.add(end - start);
            }
            currSum -= nums[start];
        }
        int minLen = Integer.MAX_VALUE;
        for (int len : res) {
            minLen = Math.min(minLen, len);
        }
        return minLen == Integer.MAX_VALUE? 0 : minLen;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5};
        int target =11;
        int res = new SmallestSubarray().minSubArrayLen(target, nums);
        System.out.println(res);
    }
}
