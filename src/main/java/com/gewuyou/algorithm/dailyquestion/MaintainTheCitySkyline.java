package com.gewuyou.algorithm.dailyquestion;

/**
 * 807. 保持城市天际线
 *
 * @author gewuyou
 * @since 2024-07-14 上午10:44:26
 */
public class MaintainTheCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        // 计算当前行的最大值
        int[] rowMax = new int[n];
        int[] colMax = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            rowMax[i] = max;
        }
        for (int j = 0; j < n; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
            colMax[j] = max;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return res;
    }
}
