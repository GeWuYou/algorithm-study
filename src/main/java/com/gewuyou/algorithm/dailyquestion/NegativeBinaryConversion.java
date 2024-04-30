package com.gewuyou.algorithm.dailyquestion;

/**
 * 1017. 负二进制转换
 *
 * @author gewuyou
 * @since 2024-04-28 下午2:17:33
 */
public class NegativeBinaryConversion {
    public String baseNeg2(int n) {
        if (n == 0 || n == 1) {
            return String.valueOf(n);
        }
        StringBuilder res = new StringBuilder();
        while (n != 0) {
            // 通过与操作符 &，获取 n 的最低位（即二进制的最后一位）。
            int remainder = n & 1;
            // 将最低位添加到结果中
            res.append(remainder);
            // 将 n 的最低位置零
            n -= remainder;
            // 右移并保持负号
            n /= -2;
        }
        return res.reverse().toString();
    }
}
