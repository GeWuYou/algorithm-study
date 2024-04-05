package com.gewuyou.algorithm.problem;

/**
 * 696. 计数二进制子串
 *
 * @author gewuyou
 * @since 2024-04-28 下午4:12:30
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int count = 0;
        // 上一种数字的个数
        int last = 0;
        // 当前数字的个数
        int curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                last = curr;
                curr = 1;
            }
            if (last >= curr) {
                count++;
            }
        }
        return count;
    }
}
