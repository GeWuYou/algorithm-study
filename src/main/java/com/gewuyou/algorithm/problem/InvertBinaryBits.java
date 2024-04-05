package com.gewuyou.algorithm.problem;

/**
 * 颠倒二进制位
 *
 * @author gewuyou
 * @since 2024-04-07 下午2:34:50
 */
public class InvertBinaryBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // return Integer.reverse(n);
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // 首先res向左移动一位为后面腾出位置
            res = (res << 1) + ((
                    // 将n与(1 << i)进行与运算，如果结果为0，则说明第i位为0，否则为1。
                    n & (
                    // (1 << i) 表示将1左移i位，这样就可以得到一个只有第i位为1的数。
                    1 << i
            )) == 0 ? 0 : 1);
        }
        return res;
    }
}
