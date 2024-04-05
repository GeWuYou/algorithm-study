package com.gewuyou.algorithm.problem;

/**
 * 74. 搜索二维矩阵
 *
 * @author gewuyou
 * @since 2024-04-21 下午1:14:36
 */
public class SearchFor2DMatrices {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int[] i : matrix) {
            // 判断某行是否有查找的价值
            if (i[0] <= target && i[cols - 1] >= target) {
                for (int j = 0; j < cols; j++) {
                    if (i[j] == target) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
