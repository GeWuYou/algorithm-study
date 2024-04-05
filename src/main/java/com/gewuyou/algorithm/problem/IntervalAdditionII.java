package com.gewuyou.algorithm.problem;

/**
 * 598. 区间加法 II
 *
 * @author gewuyou
 * @since 2024-04-24 下午1:17:43
 */
public class IntervalAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        // int[][] matrix = new int[m][n];
        // // 构建矩阵
        // for (int[] op : ops) {
        //     // 操作行
        //     int row = op[0];
        //     for (int j = 0; j < row; j++) {
        //         for (int k = 0; k < matrix[j].length; k++) {
        //             matrix[j][k]++;
        //         }
        //     }
        //     // 操作列
        //     int col = op[1];
        //     for (int j = 0; j < matrix.length; j++) {
        //         for (int k = 0; k < col; k++) {
        //             matrix[j][k]++;
        //         }
        //     }
        // }
        // // 计算最大值
        // Map<Integer,Integer> map = new HashMap<>();
        // // 遍历整个矩阵
        // for (int[] array : matrix) {
        //     for (int i : array) {
        //         map.put(i, map.getOrDefault(i, 0) + 1);
        //     }
        // }
        // int max = 0;
        // for (int i : map.keySet()) {
        //     max = Math.max(max, i);
        // }
        // return map.get(max);

        int minRow = m;
        int minCol = n;

        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }

        return minRow * minCol;
    }
}
