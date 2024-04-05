package com.gewuyou.algorithm.problem;

/**
 * 693. 交替位二进制数
 *
 * @author gewuyou
 * @since 2024-04-28 下午3:59:58
 */
public class AlternateBitBinaryNumbers {
    public boolean hasAlternatingBits(int n) {
        // 判断设置上一位的数字
        int prev = n & 1;
        // 右移
        n >>= 1;
        while (n > 0) {
            // 获取当前位的数字
            int curr = n & 1;
            // 判断当前位和上一位是否相同
            if (curr == prev) {
                return false;
            }
            prev = curr;
            n >>= 1;
        }
        return true;
    }
}
