package com.gewuyou.algorithm.dailyquestion;

/**
 * 3099. 哈沙德数
 *
 * @author gewuyou
 * @since 2024-07-03 下午6:53:33
 */
public class HashadNumber {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        String str = String.valueOf(x);
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        return x%sum == 0? sum : -1;
    }
}
