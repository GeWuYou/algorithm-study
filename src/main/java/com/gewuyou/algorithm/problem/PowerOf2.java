package com.gewuyou.algorithm.problem;

/**
 * 2 的幂
 *
 * @author gewuyou
 * @since 2024-04-09 下午12:58:46
 */
public class PowerOf2 {
    public boolean isPowerOfTwo(int n) {
       return n>0 && (n & (n-1)) == 0;
    }
}
