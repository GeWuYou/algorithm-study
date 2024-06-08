package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 3040. 相同分数的最大操作数目 II
 *
 * @author gewuyou
 * @since 2024-06-08 上午11:36:42
 */
public class MaxOperationsII {
    private int[] nums;
    private int[][] memo;
    private boolean done;

    public int maxOperations(int[] nums) {
        // 记忆化搜索
        this.nums = nums;
        int n = nums.length;
        memo = new int[n][n];
        int res1 = helper(2, n - 1, nums[0] + nums[1]); // 删除前两个数
        int res2 = helper(0, n - 3, nums[n - 2] + nums[n - 1]); // 删除后两个数
        int res3 = helper(1, n - 2, nums[0] + nums[n - 1]); // 删除第一个和最后一个数
        return Math.max(Math.max(res1, res2), res3) + 1; // 加上第一次操作
        // 动态规划 dp
        // int n = nums.length;
        // if (n == 2)
        //     return 1; // 如果元素数量少于2，则不能进行任何操作
        //
        // int[] m = new int[]{nums[0] + nums[1], nums[0] + nums[n - 1], nums[n - 1] + nums[n - 2]};
        // int[][][] dp = new int[n][n][3];
        // // dp[i][j] = max(dp[i+2][j], dp[i+1][j-1] , dp[i][j-2])
        //
        // dp[n - 2][n - 1][0] = nums[n - 1] + nums[n - 2] == m[0] ? 1 : 0;
        // dp[n - 2][n - 1][1] = nums[n - 1] + nums[n - 2] == m[1] ? 1 : 0;
        // dp[n - 2][n - 1][2] = nums[n - 1] + nums[n - 2] == m[2] ? 1 : 0;
        //
        // dp[0][2][0] = nums[0] + nums[1] == m[0] ? 1 : 0;
        // dp[0][2][1] = nums[0] + nums[1] == m[1] ? 1 : 0;
        // dp[0][2][2] = nums[0] + nums[1] == m[2] ? 1 : 0;
        // for (int i = n - 3; i >= 0; i--) {
        //     for (int j = i + 1; j < n; j++) {
        //         int tone = nums[i] + nums[i + 1], two = nums[i] + nums[j], three = nums[j] + nums[j - 1];
        //         for (int k = 0; k < m.length; k++) {
        //             dp[i][j][k] = tone == m[k] || two == m[k] || three == m[k] ? 1 : 0;
        //             if (tone == m[k])
        //                 dp[i][j][k] = Math.max(dp[i + 2][j][k] + 1, dp[i][j][k]);
        //             if (two == m[k])
        //                 dp[i][j][k] = Math.max(dp[i + 1][j - 1][k] + 1, dp[i][j][k]);
        //             if (three == m[k] && j - 2 >= 0)
        //                 dp[i][j][k] = Math.max(dp[i][j - 2][k] + 1, dp[i][j][k]);
        //         }
        //     }
        // }
        // return Math.max(dp[0][n - 1][2], Math.max(dp[0][n - 1][0], dp[0][n - 1][1]));
        // 暴力解法
        // int n = nums.length;
        // int result = Math.max(maxOperations(nums, 2, n - 1, 1, nums[0] + nums[1]), maxOperations(nums, 0, n - 3, 1, nums[n - 1] + nums[n - 2]));
        // result = Math.max(result, maxOperations(nums, 1, n - 2, 1, nums[0] + nums[n - 1]));
        // return result;
    }

    private int helper(int i, int j, int target) {
        if (done) { // 说明之前已经算出了 res = n / 2
            return 0; // 返回任意 <= n/2 的数均可
        }
        for (int[] row : memo) {
            Arrays.fill(row, -1); // -1 表示没有计算过
        }
        return dfs(i, j, target);
    }

    private int dfs(int i, int j, int target) {
        if (done) {
            return 0;
        }
        if (i >= j) {
            done = true;
            return 0;
        }
        if (memo[i][j] != -1) { // 之前计算过
            return memo[i][j];
        }
        int res = 0;
        if (nums[i] + nums[i + 1] == target) { // 删除前两个数
            res = Math.max(res, dfs(i + 2, j, target) + 1);
        }
        if (nums[j - 1] + nums[j] == target) { // 删除后两个数
            res = Math.max(res, dfs(i, j - 2, target) + 1);
        }
        if (nums[i] + nums[j] == target) { // 删除第一个和最后一个数
            res = Math.max(res, dfs(i + 1, j - 1, target) + 1);
        }
        return memo[i][j] = res; // 记忆化
    }

    private int maxOperations(int[] nums, int left, int right, int count, int target) {
        if (left >= right) {
            return count;
        }
        int result = count;
        if (left + 1 <= right && nums[left] + nums[left + 1] == target) {
            result = maxOperations(nums, left + 2, right, count + 1, target);
        }
        if (right - 1 >= left && nums[right] + nums[right - 1] == target) {
            result = Math.max(result, maxOperations(nums, left, right - 2, count + 1, target));
        }
        if (nums[left] + nums[right] == target) {
            result = Math.max(result, maxOperations(nums, left + 1, right - 1, count + 1, target));
        }
        return result;
    }

    public static void main(String[] args) {
        // int[] nums = {3, 2, 1, 2, 3, 4};
        int[] nums = {3, 2};
        MaxOperationsII solution = new MaxOperationsII();
        int result = solution.maxOperations(nums);
        System.out.println(result);
    }
}
