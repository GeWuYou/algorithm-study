package com.gewuyou.algorithm.dailyquestion;

/**
 * 分割两个字符串得到回文串
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SplitTheTwoStringsToGetAPalindromicString
 * @apiNote </br>
 * @since 2023/3/18 14:07
 */
public class SplitTheTwoStringsToGetAPalindromicString {
    public boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    public boolean check(String a, String b) {
        // 创建双指针
        int start = 0;
        int end = a.length() - 1;
        while (start < end && a.charAt(start) == b.charAt(end)) {
            start++;
            end--;
        }
        return isPalindrome(a, start, end) || isPalindrome(b, start, end);
    }

    private boolean isPalindrome(String b, int start, int end) {
        // 判断start到end是否为回文串
        while (start < end && b.charAt(start) == b.charAt(end)) {
            start++;
            end--;
        }
        return start >= end;
    }
}
