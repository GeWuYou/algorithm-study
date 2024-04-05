package com.gewuyou.algorithm.problem;

/**
 * 461. 汉明距离
 *
 * @author gewuyou
 * @since 2024-04-17 上午11:58:43
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        // 异或运算 不同为1 相同为0
        int xor = x ^ y;
        int count = 0;
        while (xor!= 0) {
            // 取最后一位如果为1 则计数加1反之不计数
            count += xor & 1;
            xor >>= 1;
        }
        return count;
    }
}
