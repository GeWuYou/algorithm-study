package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 953. 验证外星语词典
 *
 * @author gewuyou
 * @since 2024-05-10 下午3:00:44
 */
public class VerifyTheAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        // 创建字母顺序映射
        Map<Character, Integer> map = new HashMap<>(order.length());
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isAlienSorted(words[i], words[i + 1], map)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAlienSorted(String word1, String word2, Map<Character, Integer> map) {
        int n1 = 0;
        int n2 = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        while (n1 < len1 && n2 < len2 && word1.charAt(n1) == word2.charAt(n2)) {
            // 如果 word1 和 word2 的前缀相同，继续比较下一个字符
            n1++;
            n2++;
        }
        // 如果 word1 是 word2 的前缀，
        // 同时 word1 的长度小于等于 word2 的长度，则符合字典序排列
        if (n1 == word1.length()) {
            return true;
        }
        // 如果 word1 是 word2 的前缀，
        // 同时 word1 的长度大于 word2 的长度，则不符合字典序排列
        if (n2 == word2.length()) {
            return false;
        }
        // 根据字母顺序映射map进行字符的顺序比较
        int order1 = map.get(word1.charAt(n1));
        int order2 = map.get(word2.charAt(n2));
        return order1 < order2;

    }
}
