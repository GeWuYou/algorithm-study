package com.gewuyou.algorithm.problem;

/**
 * 201. 数字范围按位与
 *
 * @author gewuyou
 * @since 2024-05-19 上午11:08:31
 */
public class NumberRangeIsInTheSamePlaceAsBits {
    public int rangeBitwiseAnd(int left, int right) {
        //在进行按位与操作时，只要某一位出现0，那么结果的相应位一定是0。只需要考虑从left到right之间的公共前缀即可。
        int shift = 0;
        // 移位找到公共前缀: 公共前缀的位数即为公共前缀的二进制位数
        while (left < right) {
            // 不断右移 left 和 right，直到它们相等。每次右移后，记录移位次数 shift。
            left >>= 1;
            right >>= 1;
            shift++;
        }
        // 将公共前缀左移 shift 位，得到最终的按位与操作的结果
        return left << shift;
    }
}
