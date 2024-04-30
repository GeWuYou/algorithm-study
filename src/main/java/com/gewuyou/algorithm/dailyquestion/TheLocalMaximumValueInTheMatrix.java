package com.gewuyou.algorithm.dailyquestion;

/**
 * 矩阵中的局部最大值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TheLocalMaximumValueInTheMatrix
 * @apiNote </br>
 * @since 2023/3/1 9:57
 */
public class TheLocalMaximumValueInTheMatrix {
    public int[][] largestLocal(int[][] grid) {
        // 计算数组大小创建结果集合
        int length = grid.length;
        int[][] result = new int[length - 2][length - 2];
        for (int i = 0; i < length - 2; i++) {
            for (int j = 0; j < length - 2; j++) {
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        result[i][j] = Math.max(result[i][j], grid[k][l]);
                    }
                }
            }
        }
        return result;
    }
}
