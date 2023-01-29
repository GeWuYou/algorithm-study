package com.gewuyou.algorithm.dailyquestion;

/**
 * 判断矩阵是否是一个 X 矩阵
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName CheckIfMatrixIsAnXMatrix
 * @apiNote </br>
 * @since 2023/1/31 11:22
 */
public class CheckIfMatrixIsAnXMatrix {
    public boolean checkXMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 判断对角线
                if (i == j || i + j + 1 == grid.length) {
                    if (grid[i][j] == 0) {
                        return false;
                    } else {
                        continue;
                    }
                }
                // 判断对角线外元素
                if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
