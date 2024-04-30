package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 斐波那契数列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FibonacciSequence
 * @apiNote </br>
 * @since 2023/1/26 13:46
 */
public class FibonacciSequence {
    public int fibonacciSequence(int n) {
        // 定义变量
        // n-1
        int before = 0;
        // n
        int after = 1;
        // n+1
        int result;

        for (int i = 0; i < n; i++) {
            // 计算和 f(n+1) = f(n)+f(n-1)
            result = (before + after) % 1000000007;
            // 0 - n-1
            before = after;
            // 1 - n
            after = result;
        }
        // 因为before最后所在索引为n-1，该值为f(n)的值
        return before;
    }
}
