package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. 最长回文串
 *
 * @author gewuyou
 * @since 2024-04-15 下午2:28:29
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean flag = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if ((entry.getValue() & 1) == 0) {
                length += entry.getValue();
            } else {
                // 遇到奇数字符
                flag = true;
                length += entry.getValue() - 1;
            }
        }
        if (flag) {
            length++;
        }
        return length;
    }

}
