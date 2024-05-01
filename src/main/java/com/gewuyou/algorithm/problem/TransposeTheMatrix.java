package com.gewuyou.algorithm.problem;

/**
 * 867. 转置矩阵
 *
 * @author gewuyou
 * @since 2024-05-05 下午1:12:37
 */
public class TransposeTheMatrix {
    public int[][] transpose(int[][] matrix) {
        // int m = matrix.length;
        // int n = matrix[0].length;
        // int[][] result = new int[n][m];
        // List<Integer> list = new ArrayList<>();
        // for (int[] arr : matrix) {
        //     for (int j = 0; j < n; j++) {
        //         list.add(arr[j]);
        //     }
        // }
        // int index = 0;
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         result[j][i] = list.get(index++);
        //     }
        // }
        // return result;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] result = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

}
