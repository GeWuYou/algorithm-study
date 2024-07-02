package com.gewuyou.algorithm.dailyquestion;

/**
 * 3033. 修改矩阵
 *
 * @author gewuyou
 * @since 2024-07-05 下午9:42:16
 */
public class ModifyTheMatrix    {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //扫描矩阵找出每列最大值并标记所有值为-1的位置
        int []max = new int[n];
        for (int[] array : matrix) {
            for (int j = 0; j < n; j++) {
                max[j] = Math.max(max[j], array[j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = max[j];
                }
            }
        }
        return matrix;
    }
}
