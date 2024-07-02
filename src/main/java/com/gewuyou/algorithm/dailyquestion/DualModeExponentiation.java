package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 2961. 双模幂运算
 *
 * @author gewuyou
 * @since 2024-07-30 上午11:11:02
 */
public class DualModeExponentiation {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        int n = variables.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long res = fastPowerMod(
                    fastPowerMod(variables[i][0], variables[i][1], 10), variables[i][2], variables[i][3]);
            if (res == target) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 快速幂算法
     *
     * @param base     底数
     * @param exponent 指数
     * @param mod      模
     * @return (base ^ exponent) % mod
     */
    private long fastPowerMod(long base, int exponent, long mod) {
        long result = 1;
        // 取模以防止base过大
        long currentProduct = base % mod;
        while (exponent > 0) {
            // 如果当前指数为奇数，则乘上当前结果
            // 否则，当前结果乘上当前结果再取模
            if (exponent % 2 == 1) {
                result= (result * currentProduct) % mod;
            }
            currentProduct = (currentProduct * currentProduct) % mod;
            // 指数减半
            exponent >>= 1;
        }
        return result;
    }
}
