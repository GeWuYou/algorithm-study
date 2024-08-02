package com.gewuyou.algorithm.problem;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 3143. 正方形中的最多点数
 *
 * @author gewuyou
 * @since 2024-08-03 上午9:01:00
 */
public class TheMaximumNumberOfPointsInASquare {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;
        for (int i = 0; i < n; i++) {
            // 最长的坐标点
            points[i][0] = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
            // 设置点的标签
            points[i][1] = 1 << (s.charAt(i) - 'a');
        }
        // 排序 按照最长的坐标的点排序
        Arrays.sort(points, Comparator.comparing(o -> o[0]));
        // 存储当前最大合法正方形包含的点数
        int max = 0;
        // 记录当前正在处理的合法正方形包含的点数
        int curr = 1;
        // 记录当前正在处理的合法正方形包含的标签的二进制表示 1 2 4 8 16 32 64 128
        int tag = points[0][1];
        // 遍历每个点，计算合法正方形包含的最大点数
        for (int i = 1; i < n; i++) {
            int[] point = points[i];
            // 由于我们是从小到大排序，当最大坐标点发生变化时，说明当前合法正方形已经结束，需要更新最大值
            if (point[0] != points[i - 1][0]) {
                max += curr;
                curr = 0;
            }
            // 让当前点的标签与已经跟踪过的标签进行与运算，如果结果不为 0，说明当前点与上一个点有相同的标签，不合法，直接返回
            if ((tag & point[1]) != 0) {
                return max;
            }
            // 将当前点的标签加入到跟踪的标签中比如已经出现过 1 则有001 出现了2 有 011 出现了4 则有 111以此类推
            tag |= point[1];
            curr++;
        }
        return n;
    }
}
