package com.gewuyou.algorithm.dailyquestion;

/**
 * 2928. 给小朋友们分糖果 I
 *
 * @author gewuyou
 * @since 2024-06-01 下午2:29:48
 */
public class DistributeCandyIToTheLittleOnes {
    public int distributeCandies(int n, int limit) {
        int count = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                int k = n - i - j;
                if (k >= 0&&k <= limit) {
                    count++;
                }
            }
        }
        return count;
    }
}
