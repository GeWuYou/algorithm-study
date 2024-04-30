package com.gewuyou.algorithm.problem;

/**
 * 492. 构造矩形
 *
 * @author gewuyou
 * @since 2024-04-18 下午3:43:39
 */
public class ConstructARectangle {
    public int[] constructRectangle(int area) {
        // 计算给定面积的平方根
        int sqrt = (int) Math.sqrt(area);
        // 遍历所有可能的长宽
        for (int i = sqrt; i >= 1; i--) {
            if (area % i == 0) {
                return new int[]{area / i, i};
            }
        }
        return new int[]{0, 0};
    }
}
