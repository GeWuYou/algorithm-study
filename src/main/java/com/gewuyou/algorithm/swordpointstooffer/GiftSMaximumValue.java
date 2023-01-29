package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 礼物的最大价值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName GiftSMaximumValue
 * @apiNote </br>
 * @since 2023/1/27 13:05
 */
public class GiftSMaximumValue {
    public int maxValue(int[][] grid) {
        // 行长度
        int lineLength = grid.length;
        // 列长度
        int columnLength = grid[0].length;
        // 初始化第一行
        for (int i = 1; i < columnLength; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        // 初始化第一列
        for (int i = 1; i < lineLength; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < lineLength; i++) {
            for (int j = 1; j < columnLength; j++) {
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[lineLength - 1][columnLength-1];
    }
}
