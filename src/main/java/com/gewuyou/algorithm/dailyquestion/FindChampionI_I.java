package com.gewuyou.algorithm.dailyquestion;

/**
 * 找到冠军 I
 *
 * @author gewuyou
 * @since 2024-04-12 下午12:36:37
 */
public class FindChampionI_I {
    public int findChampion(int[][] grid) {
        int champion = 0;
        int n = grid.length;
        for (int k = 1; k < n; k++) {
            if (grid[champion][k] == 0) {
                champion = k;
            }
        }
        return champion;
    }

}
