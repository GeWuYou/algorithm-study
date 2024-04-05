package com.gewuyou.algorithm.problem;

/**
 * 字符串转整数
 *
 * @author gewuyou
 * @since 2024-04-05 下午5:02:55
 */
public class Atoi {
    public int myAtoi(String s) {
        int result = 0;
        boolean isNegative = false;
        // 丢弃空格
        s = s.trim();
        // 丢弃小数部分
        if (s.contains(".")) {
            s = s.substring(0, s.indexOf("."));
        }
        // 检查正负号
        int i = 0;
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            isNegative = s.charAt(i) == '-';
            i++;
        }

        // 处理数字部分
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            // 转换为数字
            int digit = s.charAt(i) - '0';

            // 检查溢出
            if (
                // 如果不是负数
                    !isNegative &&
                            // 如果结果大于最大值除以10
                            (result > Integer.MAX_VALUE / 10 ||
                                    // 或者结果恰好等于最大值但最后一位数字大于7即个位数溢出
                                    (result == Integer.MAX_VALUE / 10 && digit > 7))) {
                return Integer.MAX_VALUE;
            }
            if (
                // 如果是负数
                    isNegative &&
                            // 如果结果小于最小值除以10
                            (-result < Integer.MIN_VALUE / 10 ||
                                    // 或者结果恰好等于最小值但最后一位数字大于8即个位数溢出
                                    (-result == Integer.MIN_VALUE / 10 && digit > 8))) {
                return Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return isNegative ? -result : result;
    }
}
