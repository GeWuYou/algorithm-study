package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 1175. 质数排列
 *
 * @author gewuyou
 * @since 2024-05-18 下午2:36:16
 */
public class PermutationOfPrimeNumbers {
    private static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        // 判断是否是质数的辅助数组
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        // 0 和 1 不是质数
        isPrime[0] = isPrime[1] = false;

        // 使用埃拉托色尼筛法找质数
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 统计质数的数量
        int primeCount = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime[i]) {
                primeCount++;
            }
        }

        int nonPrimeCount = n - primeCount;

        // 计算质数和非质数的排列组合数量 质数有p!种排列组合，非质数有(n-p)!种排列组合 p为质数的数量，n-p为非质数的数量
        // 阶乘的计算使用long类型避免溢出
        long result = factorial(primeCount) * factorial(nonPrimeCount) % MOD;
        return (int) result;
    }

    /**
     * 计算阶乘
     *
     * @param num 阶乘的数值
     * @return 阶乘的结果
     */
    private long factorial(int num) {
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result = result * i % MOD;
        }
        return result;
    }

    public static void main(String[] args) {
        PermutationOfPrimeNumbers solution = new PermutationOfPrimeNumbers();
        int n = 100;
        int result = solution.numPrimeArrangements(n);
        System.out.println(result);
    }
}
