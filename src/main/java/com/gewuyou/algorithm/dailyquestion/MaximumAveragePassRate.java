package com.gewuyou.algorithm.dailyquestion;

import java.util.PriorityQueue;

/**
 * 最大平均通过率
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaximumAveragePassRate
 * @apiNote </br>
 * @since 2023/2/19 10:23
 */
public class MaximumAveragePassRate {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // 创建最大优先队列
        PriorityQueue<int[]> pq = new PriorityQueue<>(((a, b) -> {
            long val1 = (long) (b[1] + 1) * b[1] * (a[1] - a[0]);
            long val2 = (long) (a[1] + 1) * a[1] * (b[1] - b[0]);
            if (val1 == val2) {
                return 0;
            }
            return val1 < val2 ? 1 : -1;
        }));
        // 将班级加入最大优先队列中
        for (int[] aClass : classes) {
            pq.offer(new int[]{aClass[0], aClass[1]});
        }
        // 从最大优先队列中取出元素进行操作
        for (int i = 0; i < extraStudents; i++) {
            int[] poll = pq.poll();
            assert poll != null;
            pq.offer(new int[]{poll[0] + 1, poll[1] + 1});
        }
        // 计算最大概率
        double res = 0;
        for (int i = 0; i < classes.length; i++) {
            int[] arr = pq.poll();
            assert arr != null;
            int pass = arr[0];
            int total = arr[1];
            res += 1.0 * pass / total;
        }
        return res / classes.length;
    }
}
