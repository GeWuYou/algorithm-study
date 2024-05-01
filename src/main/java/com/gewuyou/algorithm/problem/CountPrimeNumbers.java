package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 204. 计数质数
 *
 * @author gewuyou
 * @since 2024-05-20 下午2:04:27
 */
public class CountPrimeNumbers {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        // 创建一个布尔数组，标记是否是质数 最开始默认所有数都是质数
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        // 0和1不是质数
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < n; i++) {
            // 如果i是质数，则标记i的倍数为非质数
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 统计质数的个数
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
        // int count = 0;
        // for (int i = n-1; i > 0; i--) {
        //     if (isPrime(i)) {
        //         count++;
        //     }
        // }
        // return count;
    }

    public boolean isPrime(int num) {
        // 小于等于1不是质数
        if (num <= 1) {
            return false;
        }
        // 2或者3是质数
        if (num == 2 || num == 3) {
            return true;
        }
        // 偶数不是质数
        if ((num & 1) == 0) {
            return false;
        }
        // 3的倍数不是质数
        if (num % 3 == 0) {
            return false;
        }
        // 遍历从 5 开始的奇数，直到如果num 能被任何这些数整除，则num 不是质数。
        int i = 5;
        while (i * i <= num) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }
}

















