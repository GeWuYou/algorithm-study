package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 二进制中 1 的个数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NumberOfOneSInBinary
 * @apiNote </br>
 * @since 2023/2/7 13:05
 */
public class NumberOfOneSInBinary {
    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            // 判断当前位的数字是否为1
            result += n & 1;
            // 无符号右移一位
            n >>>= 1;
        }
        return result;
    }
}
