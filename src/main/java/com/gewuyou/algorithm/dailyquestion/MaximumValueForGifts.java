package com.gewuyou.algorithm.dailyquestion;

/**
 * 礼物的最大价值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaximumValueForGifts
 * @apiNote </br>
 * @since 2023/3/8 12:10
 */
public class MaximumValueForGifts {
    public int maxValue(int[][] grid) {
        //计算行列
        int rowLength = grid.length;
        // 计算列
        int columnLength = grid[0].length;
        // 初始化行
        for (int i = 1; i < columnLength; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        // 初始化列
        for (int i = 1; i < rowLength; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        // 进行动态规划
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[rowLength-1][columnLength-1];
    }
}
