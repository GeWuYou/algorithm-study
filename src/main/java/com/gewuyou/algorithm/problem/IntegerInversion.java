package com.gewuyou.algorithm.problem;

/**
 * 整数反转
 *
 * @author gewuyou
 * @since 2024-04-08 下午2:21:30
 */
public class IntegerInversion {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            // 检查是否溢出或者刚好大于最大值或者小于最小值
            // 检查是否溢出
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + digit;
        }
        return result;
    }
}
