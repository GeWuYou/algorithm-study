package com.gewuyou.algorithm.problem;

/**
 * 盛最多水的容器
 *
 * @author gewuyou
 * @since 2024-04-08 下午2:41:20
 */
public class ContainerWithTheMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, maxArea = 0;
        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
