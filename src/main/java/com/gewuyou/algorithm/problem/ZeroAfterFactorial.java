package com.gewuyou.algorithm.problem;

/**
 * 172. 阶乘后的零
 *
 * @author gewuyou
 * @since 2024-05-16 下午5:39:10
 */
public class ZeroAfterFactorial {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
