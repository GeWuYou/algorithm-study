package com.gewuyou.algorithm.problem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证回文字符串
 *
 * @author gewuyou
 * @since 2024-04-06 下午9:42:50
 */
public class VerifyThePalindromicString {
    public boolean isPalindrome(String x) {
        // 移除标点符号与空格并转为小写
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(x);

        while (matcher.find()) {
            matcher.appendReplacement(sb, "");
        }

        matcher.appendTail(sb);
        String result = sb.toString().toLowerCase();
        // 双指针
        int left = 0, right = result.length() - 1;
        while (left < right) {
            if (result.charAt(left) != result.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
