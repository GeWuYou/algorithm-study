package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. 拼写单词
 *
 * @author gewuyou
 * @since 2024-05-18 下午2:09:10
 */
public class SpellTheWord {
    public int countCharacters(String[] words, String chars) {
        int count = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : chars.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        for (String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            char[] array = word.toCharArray();
            for (char c : array) {
                wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
            }
            boolean flag = true;
            for (char c : array) {
                if (charMap.getOrDefault(c, 0) < wordMap.get(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count += word.length();
            }
        }
        return count;
    }

    public static void main(String[] args) {

        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        int count = new SpellTheWord().countCharacters(words, chars);
        System.out.println(count);
    }
}
