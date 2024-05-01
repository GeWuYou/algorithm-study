package com.gewuyou.algorithm.dailyquestion;

import java.util.PriorityQueue;

/**
 * 1738. 找出第 K 大的异或坐标值
 *
 * @author gewuyou
 * @since 2024-05-26 上午10:50:02
 */
public class FindTheKThLargestXORCoordinateValue {
    public int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 先初始化第一个元素
                if (i == 0 && j == 0) {
                    dp[i][j] = matrix[i][j];
                }
                // 第一行取左边元素和当前元素的异或值
                else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] ^ matrix[i][j];
                }
                // 第一列取上边元素和当前元素的异或值
                else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] ^ matrix[i][j];
                }
                // 其他位置取上边元素、左边元素、左上元素和当前元素的异或值
                else {
                    dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ dp[i - 1][j - 1] ^ matrix[i][j];
                }

                // 维护最小堆
                if (minHeap.size() < k) {
                    minHeap.offer(dp[i][j]);
                } else if (dp[i][j] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.offer(dp[i][j]);
                }
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 2}, {1, 6}};
        int k = 2;
        FindTheKThLargestXORCoordinateValue solution = new FindTheKThLargestXORCoordinateValue();
        int result = solution.kthLargestValue(matrix, k);
        System.out.println(result);
    }

}
