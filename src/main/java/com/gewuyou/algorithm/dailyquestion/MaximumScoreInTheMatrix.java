package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;
import java.util.List;

/**
 * 3148. 矩阵中的最大得分
 *
 * @author gewuyou
 * @since 2024-08-15 09:49:20
 */
public class MaximumScoreInTheMatrix {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.getFirst().size();
        int[][] premin = new int[2][n];
        for (int i = 0; i < 2; ++i) {
            Arrays.fill(premin[i], Integer.MAX_VALUE);
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < m; ++i) {
            Arrays.fill(premin[i & 1], Integer.MAX_VALUE);
            for (int j = 0; j < n; ++j) {
                int pre = Integer.MAX_VALUE;
                if (i > 0) {
                    pre = Math.min(pre, premin[(i - 1) & 1][j]);
                }
                if (j > 0) {
                    pre = Math.min(pre, premin[i & 1][j - 1]);
                }
                // i = j = 0 时没有转移
                if (i + j > 0) {
                    ans = Math.max(ans, grid.get(i).get(j) - pre);
                }
                premin[i & 1][j] = Math.min(pre, grid.get(i).get(j));
            }
        }
        return ans;
    }
}
