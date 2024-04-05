package com.gewuyou.algorithm.problem;

/**
 * 459. 重复的子字符串
 *
 * @author gewuyou
 * @since 2024-04-17 上午11:13:49
 */
public class DuplicateSubstrings {
    public boolean repeatedSubstringPattern(String s) {
        if (s.length() <= 1) {
            return false;
        }
        int n = s.length();
        // 从字符串长度一半开始，如果子串长度超过一半就不可能重复构成原字符串,当然，小于1也不可能重复构成原字符串
        for (int i = n >> 1; i > 0; i--) {
            // 如果子串长度不能被原字符串长度整除，则不可能重复构成原字符串
            if (n % i == 0) {
                // 计算需要重复的次数
                int count = n / i;
                // 截取子串
                String sub = s.substring(0, i);
                // 构造重复的子串
                StringBuilder sb = new StringBuilder();
                sb.append(sub.repeat(count));
                // 如果重复的子串和原字符串相同，则返回true
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        String s = "aba";
        System.out.println(new DuplicateSubstrings().repeatedSubstringPattern(s));
    }
}
