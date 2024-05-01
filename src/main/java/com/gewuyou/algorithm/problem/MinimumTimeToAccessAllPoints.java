package com.gewuyou.algorithm.problem;

/**
 * 1266. 访问所有点的最小时间
 *
 * @author gewuyou
 * @since 2024-05-21 下午5:16:51
 */
public class MinimumTimeToAccessAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        int[] start = points[0];
        for (int i = 1; i < points.length; i++) {
            // 计算到达时间
            int [] point = points[i];
            int max = Math.max(Math.abs(point[0] - start[0]), Math.abs(point[1] - start[1]));
            time += max;
            // 更新起点
            start = point;
        }
        return time;
    }
}
