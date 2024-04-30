package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 穿过迷宫的最少移动次数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MinimumNumberOfMovesThroughTheMaze
 * @apiNote </br>
 * @since 2023/2/5 10:33
 */
public class MinimumNumberOfMovesThroughTheMaze {
    static final int INVALID = Integer.MAX_VALUE / 2;

    public int minimumMoves(int[][] grid) {
        // 计算长度
        int length = grid.length;
        // 创建三元组
        int[][][] f = new int[length][length][2];
        // 将三元组所有步数设置为INVALID
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                Arrays.fill(f[i][j], INVALID);
            }
        }
        //初始状态 f[x][y][status] x 为蛇的行坐标 y 为蛇的列坐标 status 为蛇的状态
        f[0][0][0] = 0;
        // 行循环
        for (int i = 0; i < length; ++i) {
            // 列循环
            for (int j = 0; j < length; ++j) {
                // 检查横线状态是否合法
                boolean canHorizontal = (j + 1 < length && grid[i][j] == 0 && grid[i][j + 1] == 0);
                // 检查竖线状态是否合法
                boolean canVertical = (i + 1 < length && grid[i][j] == 0 && grid[i + 1][j] == 0);
                // 向右移动
                if (i - 1 >= 0 && canHorizontal) {
                    f[i][j][0] = Math.min(f[i][j][0], f[i - 1][j][0] + 1);
                }
                if (j - 1 >= 0 && canHorizontal) {
                    f[i][j][0] = Math.min(f[i][j][0], f[i][j - 1][0] + 1);
                }
                // 向下移动
                if (i - 1 >= 0 && canVertical) {
                    f[i][j][1] = Math.min(f[i][j][1], f[i - 1][j][1] + 1);
                }
                if (j - 1 >= 0 && canVertical) {
                    f[i][j][1] = Math.min(f[i][j][1], f[i][j - 1][1] + 1);
                }
                // 旋转蛇的位置
                if (canHorizontal && canVertical && grid[i + 1][j + 1] == 0) {
                    f[i][j][0] = Math.min(f[i][j][0], f[i][j][1] + 1);
                    f[i][j][1] = Math.min(f[i][j][1], f[i][j][0] + 1);
                }
            }
        }
        // 判断终点处的步数是否发生变化，如果没变则表示蛇无法走出迷宫
        return (f[length - 1][length - 2][0] == INVALID ? -1 : f[length - 1][length - 2][0]);
    }
}
