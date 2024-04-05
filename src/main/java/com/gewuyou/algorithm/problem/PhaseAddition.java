package com.gewuyou.algorithm.problem;

/**
 * 各位相加
 *
 * @author gewuyou
 * @since 2024-04-10 下午12:10:26
 */
public class PhaseAddition {
    public int addDigits(int num) {
        int result = 0;
        while (num > 0) {
            result += num % 10;
            num /= 10;
            if (num == 0) {
                if (result >= 0 && result < 10) {
                    return result;
                } else {
                    num = result;
                    result = 0;
                }
            }
        }
        return result;
    }
}
