package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 青蛙跳台阶问题
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FrogJumpingStairsProblem
 * @apiNote </br>
 * @since 2023/1/26 14:18
 */
public class FrogJumpingStairsProblem {
    public int numWays(int n) {
        int before = 1;
        int after = 1;
        int result;
        for (int i = 0; i < n; i++) {
            result = (before + after) % 1000000007;
            before = after;
            after = result;
        }
        return before;
    }
}
