package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 顺时针打印矩阵
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PrintTheMatrixClockwise
 * @apiNote </br>
 * @since 2023/2/18 19:49
 */
public class PrintTheMatrixClockwise {
    public int[] spiralOrder(int[][] matrix) {
        // 判空
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        // 下边界
        int lowerBounder = matrix.length - 1;
        // 右边界
        int rightBorder = matrix[0].length - 1;
        // 左边界
        int leftBorder = 0;
        // 上边界
        int upperBorder = 0;
        // 计数器
        int count = 0;
        // 创建结果数组
        int[] res = new int[(lowerBounder + 1) * (rightBorder + 1)];
        while (true) {
            // 从左到右
            for (int i = leftBorder; i <= rightBorder; i++) {
                res[count++] = matrix[upperBorder][i];
            }
            // 判断上边界是否越界
            if (++upperBorder > lowerBounder) {
                break;
            }
            // 从上向下
            for (int i = upperBorder; i <= lowerBounder; i++) {
                res[count++] = matrix[i][rightBorder];
            }
            // 判断右边界是否越界
            if (--rightBorder < leftBorder) {
                break;
            }
            // 从右到左
            for (int i = rightBorder; i >= leftBorder; i--) {
                res[count++] = matrix[lowerBounder][i];
            }
            // 判断下边界是否越界
            if (--lowerBounder < upperBorder) {
                break;
            }
            // 从下往上
            for (int i = lowerBounder; i >= upperBorder; i--) {
                res[count++] = matrix[i][leftBorder];
            }
            // 判断左边界是否越界
            if (++leftBorder > rightBorder) {
                break;
            }
        }
        return res;
    }
}
