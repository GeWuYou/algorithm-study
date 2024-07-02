package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 3111. 覆盖所有点的最少矩形数目
 *
 * @author gewuyou
 * @since 2024-07-31 上午8:44:31
 */
public class MinRectanglesToCoverPoints {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int count = 0;
        // 边界初始化为-1
        int end = -1;
        // 先对点根据x坐标进行排序
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        for (int[] point : points) {
            // 如果当前点的x坐标大于end，则需要增加矩形
            if(point[0] > end){
                // 计算边界
                end = point[0]+w;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // int[][] points = {{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}};
        int[][] points = {{2, 3}, {1, 2}};
        int w = 0;
        MinRectanglesToCoverPoints solution = new MinRectanglesToCoverPoints();
        int result = solution.minRectanglesToCoverPoints(points, w);
        System.out.println(result);
    }
}
