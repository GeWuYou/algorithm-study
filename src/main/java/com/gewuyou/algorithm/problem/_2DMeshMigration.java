package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 *
 * @author gewuyou
 * @since 2024-05-21 下午4:56:31
 */
public class _2DMeshMigration {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;
        k %= total;
        int[] nums = new int[total];
        int index = k;
        for (int[] ints : grid) {
            for (int j = 0; j < m; j++) {
                nums[index] = ints[j];
                index = (index + 1) % total;
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        index = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(nums[index++]);
            }
            result.add(row);
        }
        return result;
    }
}
