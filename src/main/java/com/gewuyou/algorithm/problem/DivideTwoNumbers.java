package com.gewuyou.algorithm.problem;

/**
 * 两数相除
 *
 * @author gewuyou
 * @since 2024-04-10 下午2:31:39
 */
public class DivideTwoNumbers {
    // public int divide(int dividend, int divisor) {
    //     if(dividend==Integer.MIN_VALUE&&divisor==-1){
    //         return Integer.MAX_VALUE;
    //     }
    //     return dividend/divisor;
    // }
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE){
            if(divisor == 1){
                return Integer.MIN_VALUE;
            }
            if(divisor == -1){
                return Integer.MAX_VALUE;
            }
        }
        if(dividend != 0 && dividend == divisor){
            return 1;
        }
        boolean notRev = (dividend<0 == divisor<0);
        if(dividend < 0){
            dividend = -dividend;
        }
        if(divisor < 0){
            divisor = -divisor;
        }
        int ans = 0, q = 0;
        while(divisor - dividend <= 0){
            for(q=0; dividend - (divisor<<(q+1)) >= 0; q++);

            ans = ans + (1 << q);
            dividend = dividend - (divisor << q);
        }
        return notRev ? ans : -ans;


    }

    public int divideByBitwiseOperations(int dividend, int divisor) {
        if (dividend == 1 << 31 && divisor == -1) return (1 << 31) - 1;
        int a = Math.abs(dividend), b = Math.abs(divisor), res = 0, x = 0;
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (dividend > 0) == (divisor > 0) ? res : -res;


    }
}
