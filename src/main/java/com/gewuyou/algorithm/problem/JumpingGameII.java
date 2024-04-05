package com.gewuyou.algorithm.problem;

/**
 * 45. 跳跃游戏 II
 *
 * @author gewuyou
 * @since 2024-04-14 下午3:24:31
 */
public class JumpingGameII {
    public int jump(int[] nums) {
       int length = nums.length;
       int maxPosition = 0;
       int step = 0;
       int end = 0;
        for (int i = 0; i < length; i++) {
            // 记录当前位置nums[i]能跳到的最远位置
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // 如果到达上一个位置的最远位置，则步数+1且更换边界
            if(i==end){
                end = maxPosition;
                step++;
            }
        }
        return step;
    }
}
