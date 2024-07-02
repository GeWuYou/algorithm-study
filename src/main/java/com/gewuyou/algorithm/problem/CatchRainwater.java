package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 42. 接雨水
 *
 * @author gewuyou
 * @since 2024-07-27 上午11:45:37
 */
public class CatchRainwater {
    public int trap(int[] height) {
        // dp解法
        int ans = 0;
        int n = height.length;
        int[] leftMax = new int[n];
        Arrays.fill(leftMax, 0);
        int[] rightMax = new int[n];
        Arrays.fill(rightMax, 0);
        // 计算左边最大值
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        // 计算右边最大值
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        for (int i = 0; i < n; i++) {
            int result = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (rightMax[i] != 0 && leftMax[i] != 0 && result > 0) {
                ans += result;
            }
        }
        return ans;
        // 暴力解
        // int ans = 0;
        // int leftMax;
        // int rightMax;
        // int n = height.length;
        // for (int i = 0; i < n; i++) {
        //     leftMax = 0;
        //     rightMax = 0;
        //     for (int j = 0; j < i; j++) {
        //         leftMax = Math.max(leftMax, height[j]);
        //     }
        //     for (int j = i + 1; j < n; j++) {
        //         rightMax = Math.max(rightMax, height[j]);
        //     }
        //     int result = Math.min(leftMax, rightMax) - height[i];
        //     if (rightMax != 0 && leftMax != 0 && result > 0) {
        //         ans += result;
        //     }
        // }
        // return ans;
    }
}
