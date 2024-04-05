package com.gewuyou.algorithm.problem;

/**
 * 50. Pow(x, n)
 *
 * @author gewuyou
 * @since 2024-04-16 下午3:29:27
 */
public class Pow {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return 1.0 / (x * myPow(x, -(n + 1)));
        }
        if(n<0){
            x = 1/x;
            n = -n;
        }
        double result = 1.0;
        double base = x;
        while (n> 0) {
            // 如果n的最低为为1，则需要乘以x
            if((n&1)==1){
                result *= base;
            }
            base *= base;
            // 右移一位
            n >>= 1;
        }
        return result;
    }
}
