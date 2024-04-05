package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 丑数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName UglyNumbers
 * @apiNote </br>
 * @since 2023/3/8 12:27
 */
public class UglyNumbers {
    public int nthUglyNumber(int n) {
        // 第一个数为丑数
        int a = 0;
        int b = 0;
        int c = 0;
        // 创建dp数组
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 计算方程
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }
        return dp[n - 1];
    }

    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        int[] arr = new int[]{2, 3, 5};
        for (int j : arr) {
            while (n % j == 0) {
                n /= j;
            }
            if (n == 1) {
                return true;
            }
        }
        return false;
    }
}
