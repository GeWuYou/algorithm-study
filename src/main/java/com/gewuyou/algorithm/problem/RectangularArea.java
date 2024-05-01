package com.gewuyou.algorithm.problem;

/**
 * 223. 矩形面积
 *
 * @author gewuyou
 * @since 2024-05-23 下午6:13:18
 */
public class RectangularArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 计算两个矩形的面积
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        // 计算两个矩形的重叠面积
        int overlapX = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapY = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        // 计算重叠面积
        int overlapArea = overlapX * overlapY;
        // 计算总面积
        return area1 + area2 - overlapArea;
    }
}
