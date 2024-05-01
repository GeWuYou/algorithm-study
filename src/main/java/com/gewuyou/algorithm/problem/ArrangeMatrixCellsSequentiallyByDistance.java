package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 1030. 距离顺序排列矩阵单元格
 *
 * @author gewuyou
 * @since 2024-05-15 上午10:21:23
 */
public class ArrangeMatrixCellsSequentiallyByDistance {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int row = rows * cols;
        int[][] res = new int[row][2];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[index][0] = Math.abs(i - rCenter);
                res[index][1] = Math.abs(j - cCenter);
                index++;
            }
        }
        Arrays.sort(res, (a, b) -> {
            int dis1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int dis2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return Integer.compare(dis1, dis2);
        });
        return res;
    }
}
