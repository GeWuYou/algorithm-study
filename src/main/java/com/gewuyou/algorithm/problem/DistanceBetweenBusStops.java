package com.gewuyou.algorithm.problem;

/**
 * 1184. 公交站间的距离
 *
 * @author gewuyou
 * @since 2024-05-18 下午2:51:37
 */
public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int n = distance.length;
        int sum1 = 0;
        if (start > destination) {
            return distanceBetweenBusStops(distance, destination, start);
        }
        for (int i = start; i < destination; i++) {
            sum1 += distance[i];
        }

        int sum2 = 0;
        for (int i = destination; i < start + n; i++) {
            sum2 += distance[i % n];
        }
        return Math.min(sum1, sum2);
    }

    public static void main(String[] args) {
        int[] distance = {7, 10, 1, 12, 11, 14, 5, 0};
        int start = 7;
        int destination = 2;
        int result = new DistanceBetweenBusStops().distanceBetweenBusStops(distance, start, destination);
        System.out.println(result);
    }
}
