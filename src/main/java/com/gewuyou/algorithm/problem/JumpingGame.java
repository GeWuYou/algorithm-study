package com.gewuyou.algorithm.problem;

/**
 * 55. 跳跃游戏
 *
 * @author gewuyou
 * @since 2024-04-18 下午3:48:35
 */
public class JumpingGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // 记录当前能跳到的最远距离
        int currentMax = 0;
        // 记录总共能跳到的最远距离
        int totalMax = 0;
        for (int i = 0; i < n; i++) {
            // 记录当前能跳到的最远距离
            currentMax = Math.max(currentMax, i + nums[i]);
            // 如果遍历到了当前能跳到的最远距离，则更新总共能跳到的最远距离
            if (i == totalMax) {
                totalMax = currentMax;
            }
        }
        return totalMax >= n - 1;
    }
}
