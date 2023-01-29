package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 二维数组中的查找
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FindNumberIn2DArray
 * @apiNote </br>
 * @since 2023/1/22 20:33
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int start = 0;
        // 逆向检查行首
        for (int row = matrix.length - 1; row >= 0; row--) {
            // 如果首元素就大于目标值，则没有继续的必要
            if (matrix[row][0] > target) {
                continue;
            }
            for (int i = start; i < matrix[0].length; i++) {
                if (matrix[row][i] == target) {
                    return true;
                }
                // 当遇到第一个大于目标值的节点时，记录位置，并设置为下一次循环的起点
                if (matrix[row][i] > target) {
                    start = i;
                    break;
                }
            }
        }
        return false;
    }
}
