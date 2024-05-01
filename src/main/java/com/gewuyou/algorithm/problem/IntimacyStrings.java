package com.gewuyou.algorithm.problem;

/**
 * 859. 亲密字符串
 *
 * @author gewuyou
 * @since 2024-05-05 下午12:15:46
 */
public class IntimacyStrings {
    public boolean buddyStrings(String s, String goal) {
        // 1. 长度不同，返回false
        if (s.length() != goal.length()) {
            return false;
        }
        // 2. 长度相同，判断是否有重复字符，有则返回true
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            for (int c : count) {
                if (c > 1) {
                    return true;
                }
            }
        }

        // 3. 长度相同，判断是否有相同字符对，有则返回true
        int first = -1, second = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false;
                }
            }
        }
        return (second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first));
    }

    public static void main(String[] args) {
        IntimacyStrings intimacyStrings = new IntimacyStrings();
        System.out.println(intimacyStrings.buddyStrings("abab", "abab"));
        // System.out.println(intimacyStrings.buddyStrings("ab", "ab"));
        // System.out.println(intimacyStrings.buddyStrings("aa", "aa"));
        // System.out.println(intimacyStrings.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }
}
