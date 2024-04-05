package com.gewuyou.algorithm.problem;

/**
 * 342. 4的幂
 *
 * @author gewuyou
 * @since 2024-04-12 下午1:47:01
 */
public class PowerOf4 {
    public boolean isPowerOfFour(int n) {
        /*
         * 我们首先检查这个数是否是正数，并且是2的幂，
         * 即 (num > 0 && (num & (num - 1)) == 0)。接着，
         * 我们使用位运算来判断这个数是否满足4的幂的特性。
         * 4的幂的特性是，在二进制表示中，其1位出现在奇数位置（如1、4、16、64等），
         * 因此我们可以使用掩码0x55555555
         * （二进制位01010101010101010101010101010101）来进行按位与运算，
         * 判断1是否出现在奇数位上。
         *
         */
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
