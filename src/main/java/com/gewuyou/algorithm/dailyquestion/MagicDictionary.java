package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 676. 实现一个魔法字典
 *
 * @author gewuyou
 * @since 2024-08-12 11:07:26
 */
public class MagicDictionary {
    private final Set<String> dictionary;
    private final char[] charArr;

    public MagicDictionary() {
        dictionary = new HashSet<>();
        charArr = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    }

    public void buildDict(String[] dictionary) {
        this.dictionary.addAll(Arrays.asList(dictionary));
    }

    public boolean search(String searchWord) {
        int n = searchWord.length();
        for (int j = 0; j < n; j++) {
            for (char c : charArr) {
                // 跳过相同字符的替换，避免多余计算
                if (c == searchWord.charAt(j)) {
                    continue;
                }
                // 使用StringBuilder避免多余的字符串创建
                StringBuilder sub = new StringBuilder(searchWord);
                sub.setCharAt(j, c);

                if (dictionary.contains(sub.toString())) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        String[] dictionary = {"hello", "hallo", "leetcode"};
        magicDictionary.buildDict(dictionary);
        System.out.println(magicDictionary.search("leetcodd"));
    }
}
