package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 数字序列中某一位的数字
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ADigitInASequenceOfDigits
 * @apiNote </br>
 * @since 2023/3/9 13:24
 */
public class ADigitInASequenceOfDigits {
    public int findNthDigit(int n) {
        // 位数
        int digit = 1;
        // 起始位置
        long start = 1;
        // 总数
        long count = 9;
        while (n > count) {
            // 修改n
            n -= count;
            // 改变起始位置
            start *= 10;
            // 增加位数
            digit++;
            // 计算总数
            count = digit * start * 9;
        }
        // 计算此时的数字
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
