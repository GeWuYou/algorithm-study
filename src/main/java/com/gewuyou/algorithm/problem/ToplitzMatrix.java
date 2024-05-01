package com.gewuyou.algorithm.problem;

/**
 * 766. 托普利茨矩阵
 *
 * @author gewuyou
 * @since 2024-05-02 下午1:28:21
 */
public class ToplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (r > 0 && c > 0 && matrix[r - 1][c - 1] != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
