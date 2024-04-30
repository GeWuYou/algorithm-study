package com.gewuyou.algorithm.problem;

/**
 * 326. 3 的幂
 *
 * @author gewuyou
 * @since 2024-04-12 下午12:51:36
 */
public class PowerOf3 {
    public boolean isPowerOfThree(int n) {
        // return n > 0 && 1162261467%n == 0;
        int temp = 1;
        int x =1;
        while (temp<n){
            temp = (int) Math.pow(3,x++);
        }
        if(temp== Integer.MAX_VALUE){
            return false;
        }
        if(temp==n){
            return true;
        }
        return false;
    }
}
