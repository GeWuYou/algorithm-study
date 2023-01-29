package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 股票的最大利润
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaximumProfitOnStocks
 * @apiNote </br>
 * @since 2023/1/26 15:10
 */
public class MaximumProfitOnStocks {
    public int maxProfit(int[] prices) {
        // 成本
        int cost = Integer.MAX_VALUE;
        // 利润 = 价格-成本
        int profit = 0;
        // 价格
        int price;
        for (int j : prices) {
            // 记录当天价格
            price = j;
            // 如果当天价格低于之前成本则更新成本
            if (j < cost) {
                cost = j;
            }
            // 计算利润
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
