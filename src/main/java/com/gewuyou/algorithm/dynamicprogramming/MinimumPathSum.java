package com.gewuyou.algorithm.dynamicprogramming;

/**
 * 最小路径和
 *
 * @author gewuyou
 * @since 2024-02-25 16:38:24
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 起点
                if (i == 0 && j == 0) {
                    continue;
                }
                // 当只有左边是矩形边界时：赋值给当前格子值为与上方格子的和
                if (i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j - 1];
                }
                // 当只有上边是矩形边界时：赋值给当前格子值为与左方格子的和
                else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i - 1][j];
                }
                // 当左边和上边都不是矩形边界时：判断当前位置上方和与左方的最小值赋值给当前格子
                else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
