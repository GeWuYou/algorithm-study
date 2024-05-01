package com.gewuyou.algorithm.problem;

/**
 * 221. 最大正方形
 *
 * @author gewuyou
 * @since 2024-05-23 下午4:00:08
 */
public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int [][] dp = new int[n][m];
        int maxSide = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
