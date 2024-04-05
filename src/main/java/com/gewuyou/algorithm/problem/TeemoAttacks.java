package com.gewuyou.algorithm.problem;

/**
 * 495. 提莫攻击
 *
 * @author gewuyou
 * @since 2024-04-19 下午12:47:13
 */
public class TeemoAttacks {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        if (timeSeries.length == 1) {
            return duration;
        }
        int currentTime = timeSeries[0];
        int result = 0;
        for (int i = 1; i < timeSeries.length; i++) {
            int endTime = currentTime + duration;
            if (timeSeries[i] < endTime) {
                result += timeSeries[i] - currentTime;

            } else {
                result += duration;
            }
            currentTime = timeSeries[i];
        }
        return result+duration;
    }
}
