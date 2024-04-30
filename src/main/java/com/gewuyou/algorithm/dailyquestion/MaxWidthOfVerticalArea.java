package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 两点之间不包含任何点的最宽垂直区域
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaxWidthOfVerticalArea
 * @apiNote </br>
 * @since 2023/3/30 13:49
 */
public class MaxWidthOfVerticalArea {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int result = 0;
        for (int i = 1; i < points.length; i++) {
            result=Math.max(result, points[i][0] - points[i - 1][0]);
        }
        return result;
    }
}
