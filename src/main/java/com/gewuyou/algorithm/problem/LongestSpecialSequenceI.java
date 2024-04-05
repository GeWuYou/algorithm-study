package com.gewuyou.algorithm.problem;

/**
 * 521. 最长特殊序列 Ⅰ
 *
 * @author gewuyou
 * @since 2024-04-21 上午10:27:05
 */
public class LongestSpecialSequenceI {
    public int findLUSlength(String a, String b) {
        if(a.equals(b)){
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
