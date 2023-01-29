package com.gewuyou.algorithm.dailyquestion;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/6/27 21:20
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        // f(n) = f(n-1) + f(n-2))
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
}
