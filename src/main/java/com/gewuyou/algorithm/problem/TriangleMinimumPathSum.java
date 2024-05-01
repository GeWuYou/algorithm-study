package com.gewuyou.algorithm.problem;

import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @author gewuyou
 * @since 2024-05-05 下午2:47:37
 */
public class TriangleMinimumPathSum {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 最左边的元素只有一种情况就是从上一层的最左边元素到当前元素
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }
                // 最右边的元素只有一种情况就是从上一层的最右边元素到当前元素
                else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }
                // 其他元素有两种情况，从上一层的左边元素到当前元素和从上一层的右边元素到当前元素
                else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }

        return min;
    }
}
