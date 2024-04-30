package com.gewuyou.algorithm.dailyquestion;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 减半数组
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/7/25 9:13
 */
public class HalveArray {
    public static int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.offer((double) num);
        }
        int res = 0;
        double sum = 0;
        for (int num : nums) {
            sum += num;
        }
        double sum2 = 0.0;
        while (sum2 < sum / 2) {
            double x = pq.poll();
            sum2 += x / 2;
            pq.offer(x / 2);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 19, 8, 1};
        halveArray(nums);
    }
}
