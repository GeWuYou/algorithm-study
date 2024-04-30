package com.gewuyou.algorithm.dailyquestion;

/**
 * 圆和矩形是否有重叠
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/6/25 8:41
 */
public class WhetherTheCircleAndRectangleOverlap {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        double distance = 0;
        if (xCenter < x1 || xCenter > x2) {
            distance += Math.min(Math.pow(xCenter - x1, 2), Math.pow(xCenter - x2, 2));
        }
        if (yCenter < y1 || yCenter > y2) {
            distance += Math.min(Math.pow(yCenter - y1, 2), Math.pow(yCenter - y2, 2));
        }
        return distance <= Math.pow(radius, 2);
    }
}
