package com.gewuyou.algorithm.dailyquestion;

/**
 * 3146. 两个字符串的排列差
 *
 * @author gewuyou
 * @since 2024-08-24 09:39:22
 */
public class ArrangementOfTheTwoStringsIsPoor {
    public int findPermutationDifference(String s, String t) {
        int[] count = new int[26];
        int sLength = s.length();
        int tLength = t.length();
        for (int i = 0; i < sLength; i++) {
            count[s.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < tLength; i++) {
            count[t.charAt(i) - 'a'] = Math.abs(count[t.charAt(i) - 'a'] - i);
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += count[i];
        }
        return result;
    }
}
