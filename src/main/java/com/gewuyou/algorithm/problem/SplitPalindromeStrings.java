package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 *
 * @author gewuyou
 * @since 2024-05-07 下午8:09:51
 */
public class SplitPalindromeStrings {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, result, new ArrayList<>());
        return result;
    }

    /**
     * 分割回文串
     *
     * @param s      源字符串
     * @param start  分割点
     * @param result 结果集
     * @param temp   临时结果集
     */
    private void partition(String s, int start, List<List<String>> result, List<String> temp) {
        // 结束条件
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // 判断是否为回文串
            if (isPalindrome(s, start, i)) {
                temp.add(s.substring(start, i + 1));
                // 递归
                partition(s, i + 1, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
