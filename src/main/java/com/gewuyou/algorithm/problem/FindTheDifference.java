package com.gewuyou.algorithm.problem;

/**
 * 找不同
 *
 * @author gewuyou
 * @since 2024-04-14 下午12:29:17
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int len = s.length();
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        int res = 0;
        for (int i = 0; i < len; i++) {
            // chs[i]^cht[i]如果两个字符相同则为0，否则留下他们的异或值，
            // 如果两个字符串完全相同，他们异或的最终结果为0
            res ^= chs[i] ^ cht[i];
        }
        res ^= cht[len];
        // 因为字符串只有一个字符是不同的，因此最后剩下的值一定是它的ascii码值
        return (char) res;
    }
}
