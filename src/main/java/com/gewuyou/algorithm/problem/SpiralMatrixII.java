package com.gewuyou.algorithm.problem;

/**
 * 59. 螺旋矩阵 II
 *
 * @author gewuyou
 * @since 2024-04-18 下午3:58:07
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        // 下边界
        int lowerBounder = n - 1;
        // 右边界
        int rightBorder = n - 1;
        // 左边界
        int leftBorder = 0;
        // 上边界
        int upperBorder = 0;
        // 计数器
        int num = 1;
        while (num <= n * n) {
            // 从左到右
            for (int i = leftBorder; i <= rightBorder; i++) {
                result[upperBorder][i] = num++;
            }
            upperBorder++;
            // 从上到下
            for (int i = upperBorder; i <= lowerBounder; i++) {
                result[i][rightBorder] = num++;
            }
            rightBorder--;
            // 从右到左
            for (int i = rightBorder; i >= leftBorder; i--) {
                result[lowerBounder][i] = num++;
            }
            lowerBounder--;
            // 从下到上
            for (int i = lowerBounder; i >= upperBorder; i--) {
                result[i][leftBorder] = num++;
            }
            leftBorder++;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        spiralMatrixII.generateMatrix(3);

    }
}
