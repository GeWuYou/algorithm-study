package com.gewuyou.algorithm.dailyquestion;

/**
 * 3152. 特殊数组 II
 *
 * @author gewuyou
 * @since 2024-08-13 11:23:56
 */
public class SpecialArrayII {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] dp = new int[n - 1];
        // 预处理dp数组
        for (int i = 0; i < n - 1; i++) {
            if (((nums[i] & 1) == 0) != ((nums[i + 1] & 1) == 0)) {
                // dp[i]表示nums[i]和nums[i+1]是否构成特殊数组
                dp[i] = 1;
            }
        }
        int[] prefix = new int[n];
        // 构建前缀和数组
        for (int i = 1; i < n; i++) {
            // prefix[i]表示nums[0]到nums[i]的特殊数组个数
            prefix[i] = prefix[i - 1] + dp[i - 1];
        }
        // 处理查询
        boolean[] res = new boolean[m];
        for (int i = 0; i < m; i++) {
            // 单个元素一定是特殊数组
            if(queries[i][0]==queries[i][1]){
                res[i] = true;
            }else {
                //对于查询 [from, toi]，检查 prefix[toi-1] - prefix[from-1] == toi - from 是否成立，成立则子数组为特殊数组。
                int diff = prefix[queries[i][1]] - prefix[queries[i][0]];
                res[i] = queries[i][1]-queries[i][0] == diff;
            }
        }
        return res;
    }
}
