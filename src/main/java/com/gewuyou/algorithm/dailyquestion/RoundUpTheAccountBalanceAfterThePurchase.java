package com.gewuyou.algorithm.dailyquestion;

/**
 * 2806. 取整购买后的账户余额
 *
 * @author gewuyou
 * @since 2024-06-12 下午8:33:03
 */
public class RoundUpTheAccountBalanceAfterThePurchase {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int fold = 0;
        while (fold*10 < purchaseAmount) {
            fold++;
        }
        // 判断两个倍数结果
        int cost1 = (fold-1) *10;
        int cost2 = fold * 10;
        int result1 = Math.abs(purchaseAmount - cost1);
        int result2 = Math.abs(purchaseAmount - cost2);
        if (result1<result2) {
            return 100-cost1;
        }else {
            return 100-cost2;
        }
    }
}
