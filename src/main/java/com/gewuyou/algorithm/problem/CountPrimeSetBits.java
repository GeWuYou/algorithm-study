package com.gewuyou.algorithm.problem;

/**
 * 762. 二进制表示中质数个计算置位
 *
 * @author gewuyou
 * @since 2024-05-01 下午1:19:00
 */
public class CountPrimeSetBits {
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            // 计算i的二进制表示中1的个数
            int countBits = 0;
            int temp = i;
            while (temp != 0) {
                temp = temp & (temp - 1);
                countBits++;
            }
            // 判断i是否为质数
            if (isPrime(countBits)) {
                count++;
            }
        }
        return count;
    }
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        // 从2开始遍历到 n 的平方根
        for (int i = 2; i * i <= n; i++) {
            // 如果 n 能被 i 整除，则 n 不是质数
            if (n % i == 0) {
                return false;
            }
        }
        // 如果 n 不能被 2 到 sqrt(n) 之间的任何整数整除，则 n 是质数
        return true;
    }

}
