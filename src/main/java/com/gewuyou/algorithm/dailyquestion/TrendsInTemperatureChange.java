package com.gewuyou.algorithm.dailyquestion;

/**
 * LCP 61. 气温变化趋势
 *
 * @author gewuyou
 * @since 2024-06-21 上午11:51:13
 */
public class TrendsInTemperatureChange {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        int count = 0;
        int currCount = 0;
        int n = temperatureA.length;
        int a;
        int b;
        for (int i = 1; i < n; i++) {
            a = Integer.compare(temperatureA[i], temperatureA[i - 1]);
            b = Integer.compare(temperatureB[i], temperatureB[i - 1]);
            if(a==b){
                currCount++;
            }else{
                count = Math.max(count, currCount);
                currCount = 0;
            }
        }
        return Math.max(count, currCount);
    }
}
