package com.gewuyou.algorithm.problem;

/**
 * 位1的个数
 *
 * @author gewuyou
 * @since 2024-04-07 下午2:56:09
 */
public class NumberOfBits1 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }
}
