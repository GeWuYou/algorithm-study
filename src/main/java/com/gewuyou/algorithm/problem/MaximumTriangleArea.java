package com.gewuyou.algorithm.problem;

/**
 * 812. 最大三角形面积
 *
 * @author gewuyou
 * @since 2024-05-03 下午2:02:59
 */
public class MaximumTriangleArea {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    //
                    double area = Math.abs(
                            (points[i][0] * (points[j][1] - points[k][1]) + points[j][0] * (points[k][1] - points[i][1]) + points[k][0] * (points[i][1] - points[j][1])) / 2.0);
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }
        return maxArea;
    }
}
