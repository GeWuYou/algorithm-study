package com.gewuyou.algorithm.problem;

/**
 * 566. 重塑矩阵
 *
 * @author gewuyou
 * @since 2024-04-23 下午5:10:35
 */
public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int mr = mat.length;
        int mc = mat[0].length;
        if (mr * mc != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        // 行 列
        int row = 0, col = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                result[row][col] = mat[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int r = 1, c = 4;
        ReshapeTheMatrix reshapeTheMatrix = new ReshapeTheMatrix();
        int[][] result = reshapeTheMatrix.matrixReshape(mat, r, c);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
