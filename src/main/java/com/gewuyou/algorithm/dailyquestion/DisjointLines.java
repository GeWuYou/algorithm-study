package com.gewuyou.algorithm.dailyquestion;

/**
 * 1035. 不相交的线
 *
 * @author gewuyou
 * @since 2024-08-11 09:09:20
 */
public class DisjointLines {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int count = 0;
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    count = Math.max(count, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return count;
    }
}
