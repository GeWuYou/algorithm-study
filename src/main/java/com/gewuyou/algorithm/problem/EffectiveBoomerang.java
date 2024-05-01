package com.gewuyou.algorithm.problem;

/**
 * 1037. 有效的回旋镖
 *
 * @author gewuyou
 * @since 2024-05-15 上午10:52:44
 */
public class EffectiveBoomerang {
    public boolean isBoomerang(int[][] points) {
        if (points.length != 3) {
            throw new IllegalArgumentException("Exactly three points are required.");
        }

        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        // 计算叉积
        int crossProduct = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);

        // 如果叉积为零，则三点共线
        return !(crossProduct == 0);
    }

    public static void main(String[] args) {
        EffectiveBoomerang eb = new EffectiveBoomerang();
        int[][] points = {{1,1}, {2,2}, {3,3}};
        System.out.println(eb.isBoomerang(points));
    }
}
