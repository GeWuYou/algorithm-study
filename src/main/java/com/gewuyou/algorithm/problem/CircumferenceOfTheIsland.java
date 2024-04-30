package com.gewuyou.algorithm.problem;

/**
 * 463. 岛屿的周长
 *
 * @author gewuyou
 * @since 2024-04-17 下午12:17:19
 */
public class CircumferenceOfTheIsland {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int circumference = 4;
                // 一共有四种情况 上方有陆地，下方有陆地，左方有陆地，右方有陆地
                // 四周有路地则不统计
                // 岛屿
                if (grid[i][j] == 1) {
                    // 上方有陆地
                    if (j > 0 && grid[i][j - 1] == 1) {
                        circumference--;
                    }
                    // 下方有陆地
                    if (j < cols - 1 && grid[i][j + 1] == 1) {
                        circumference--;
                    }
                    // 左方有陆地
                    if (i > 0 && grid[i - 1][j] == 1) {
                        circumference--;
                    }
                    // 右方有陆地
                    if (i < rows - 1 && grid[i + 1][j] == 1) {
                        circumference--;
                    }
                    perimeter += circumference;
                }
            }
        }
        return perimeter;
    }
}