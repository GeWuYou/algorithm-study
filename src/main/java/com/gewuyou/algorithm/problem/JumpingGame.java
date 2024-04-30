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
        // 记录总共能跳到的最远距离
        int maxPosition = 0;
        // 记录当前能跳到的最远距离
        int end = 0;
        for (int i = 0; i < n; i++) {
            // 记录当前能跳到的最远距离
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                // 更新边界
                end = maxPosition;
            }
        }
        return end >= n - 1;
    }
}
