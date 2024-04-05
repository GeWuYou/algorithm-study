package com.gewuyou.algorithm.problem;

/**
 * 73. 矩阵置零
 *
 * @author gewuyou
 * @since 2024-04-20 上午11:01:07
 */
public class MatrixIsZeroed {
    /*
     * 标记需要清零的行和列： 首先遍历整个矩阵，当发现某个元素为0时，
     *   就将该元素所在的行和列的第一个元素（或者任意一个已经被清零的元素）设为0，作为标记。
     *
     * 清零标记所在的行和列： 接下来，再次遍历整个矩阵，
     * 当遇到某个元素所在的行或列的第一个元素为0时，将该元素设为0。
     *
     * */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // 检查第一行是否有0
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // 检查第一列是否有0
        for (int[] i : matrix) {
            if (i[0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // 标记需要清零的行和列
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 清零标记所在的行和列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 如果元素所在的行或列的第一个元素为0，则清零
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 清零第一行
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // 清零第一列
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

