package com.gewuyou.algorithm.dailyquestion;

/**
 * 2639. 查询网格图中每一列的宽度
 *
 * @author gewuyou
 * @since 2024-04-27 上午10:59:50
 */
public class QueryTheWidthOfEachColumnInTheGridChart {
    public int[] findColumnWidth(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int[] arr : grid) {
                max = Math.max(max, String.valueOf(arr[j]).length());
            }
            res[j] = max;
        }
        return res;
    }
}
