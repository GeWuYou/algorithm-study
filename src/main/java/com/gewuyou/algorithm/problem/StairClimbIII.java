package com.gewuyou.algorithm.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 爬楼梯3
 *
 * @author gewuyou
 * @since 2024-08-07 上午10:56:38
 */
public class StairClimbIII {
    public static int climbStairs(int n, int[] dislikes) {
        // 创建dp数组
        int[] dp = new int[n + 1];
        // 从0阶到0阶只有一种情况
        dp[0] = 1;
        // 将不喜欢的阶梯加入到set中
        Set<Integer> set = new HashSet<>();
        for (int dislike : dislikes) {
            set.add(dislike);
        }
        for (int i = 1; i <= n; i++) {
            // 如果是喜欢的阶梯则赋值
            if (!set.contains(i)) {
                dp[i] += dp[i - 1];
                if (i >= 2) {
                    dp[i] += dp[i - 2];
                }
                if (i >= 3) {
                    dp[i] += dp[i - 3];
                }
                if (i >= 4) {
                    dp[i] += dp[i - 4];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n1 = 5;
        int[] dislikes1 = {2, 4};
        System.out.println("Test Case 1: " + climbStairs(n1, dislikes1)); // 3
    }
}
