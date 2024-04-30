package com.gewuyou.algorithm.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 快乐数
 *
 * @author gewuyou
 * @since 2024-04-07 下午5:54:54
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        // 如果n不等于1，并且set中没有n，则进入循环
        // 循环中，求n的每位数字的平方和，并将结果赋值给n
        // 直到n等于1或者set中有n，则返回true
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
