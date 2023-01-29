package com.gewuyou.algorithm.dynamicprogramming;

/**
 * 不同路径2
 *
 * @author gewuyou
 * @since 2024-02-25 18:43:52
 */
public class DifferentPathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                 // 如果是障碍物则赋值为0
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                // 如果当前格子是起点则赋值为1
                else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                // 如果当前格子在第一行则将当前格子的值赋值为左侧格子的dp值(dp[i][j - 1])
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                }
                // 如果当前格子在第一列则将当前格子的值赋值为上方格子的dp值(dp[i - 1][j])
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                // 如果当前格子不在第一行和第一列则将 dp[i][j] 的值设为上方格子的 dp 值与左侧格子的 dp 值之和（dp[i - 1][j] + dp[i][j - 1]）。
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
