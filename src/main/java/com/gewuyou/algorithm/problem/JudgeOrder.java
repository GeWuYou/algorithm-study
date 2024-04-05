package com.gewuyou.algorithm.problem;

/**
 * 392. 判断子序列
 *
 * @author gewuyou
 * @since 2024-04-14 下午1:00:43
 */
public class JudgeOrder {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        for (char c : tCharArray) {
            if (i == s.length()) {
                return true;
            }
            if (sCharArray[i] == c) {
                i++;
            }
        }
        if (i == s.length()) {
            return true;
        }
        return false;
    }
}
