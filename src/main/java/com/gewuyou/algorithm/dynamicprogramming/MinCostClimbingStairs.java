package com.gewuyou.algorithm.dynamicprogramming;

/**
 * 花费最小的代价爬楼梯
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/6/28 11:10
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        // 起步可以从0或者1出发
        // 0阶处
        int prev = 0;
        // 1阶处
        int curr = 0;
        for (int i = 2; i <= cost.length; i++) {
            // curr = 1  i - 1 = 1  prev = 0 i - 2 = 0
            int temp = Math.min(curr + cost[i - 1], prev + cost[i - 2]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}
