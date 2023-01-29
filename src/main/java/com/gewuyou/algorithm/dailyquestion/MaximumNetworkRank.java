package com.gewuyou.algorithm.dailyquestion;

/**
 * 最大网络秩
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaximumNetworkRank
 * @apiNote </br>
 * @since 2023/3/15 12:05
 */
public class MaximumNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] board = new boolean[n][n];
        int[] degree = new int[n];
        for (int[] road : roads) {
            // 将计算过的路设为true
            board[road[0]][road[1]] = true;
            board[road[1]][road[0]] = true;
            degree[road[0]]++;
            degree[road[1]]++;
        }
        int maxRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxRank = Math.max(maxRank, degree[i] + degree[j] - (board[i][j] ? 1 : 0));
            }

        }
        return maxRank;
    }
}
