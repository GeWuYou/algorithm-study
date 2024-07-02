package com.gewuyou.algorithm.problem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 *
 * @author gewuyou
 * @since 2024-07-30 下午1:51:56
 */
public class FindMinArrowShots {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        // 首先，将所有气球按照其结束位置进行升序排序。这是因为结束位置较早的气球更容易被引爆，并且可能会与其他气球的范围重叠。
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        int curr = points[0][1];
        for (int i = 1; i < n; i++) {
            if (points[i][0] > curr) {
                // 更新当前气球的结束位置
                curr = points[i][1];
                count++;
            }
        }
        return count;
    }
}
