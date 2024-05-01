package com.gewuyou.algorithm.problem;

/**
 * 883. 三维形体投影面积
 *
 * @author gewuyou
 * @since 2024-05-06 下午2:35:48
 */
public class ProjectedAreaOfThe3DShape {
    public int projectionArea(int[][] grid) {
        int res = 0;
        int n = grid.length;
        int xy = 0;
        for (int[] s : grid) {
            for (int j = 0; j < n; j++) {
                if (s[j] > 0) {
                    xy++;
                }
            }
        }
        res += xy;
        for (int[] s : grid) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (s[j] > max) {
                    max = s[j];
                }
            }
            res += max;
        }
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int[] s : grid) {
                if (s[j] > max) {
                    max = s[j];
                }
            }
            res += max;
        }
        return res;
    }
}
