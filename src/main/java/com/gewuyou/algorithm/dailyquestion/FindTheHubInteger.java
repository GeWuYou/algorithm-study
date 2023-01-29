package com.gewuyou.algorithm.dailyquestion;

/**
 * 找出中枢整数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/6/26 7:14
 */
public class FindTheHubInteger {
    public int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }
        // 计算从1-n的和
        int xSum = 0;
        for (int i = 1; i <= n; i++) {
            xSum += i;
        }
        // 计算1-x与x-n的和

        int sum = 0;
        for (int i = 1; i < n; i++) {
            xSum -= i;
            if (xSum == sum) {
                return i;
            }
            sum += i;

        }
        return -1;
    }
}
