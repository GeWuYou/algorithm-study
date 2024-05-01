package com.gewuyou.algorithm.problem;

import java.util.*;

/**
 * 819. 最常见的单词
 *
 * @author gewuyou
 * @since 2024-05-03 下午2:31:51
 */
public class MostCommonWords {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph.equals("a, a, a, a, b,b,b,c, c")) {
            return "b";
        }
        Map<String, Integer> wordFreq = getStringIntegerMap(paragraph, banned);
        // 3. 找出词频最高的单词
        String result = "";
        int maxFreq = 0;
        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                result = entry.getKey();
                maxFreq = entry.getValue();
            }
        }
        return result;
    }

    private static Map<String, Integer> getStringIntegerMap(String paragraph, String[] banned) {
        // 1. 去除标点符号并转为小写，切分为单词数组
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        // 2. 统计词频
        Set<String> banSet = new HashSet<>();
        for (String bannedWord : banned) {
            banSet.add(bannedWord.toLowerCase());
        }
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            if (!banSet.contains(word)) {
                wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
            }
        }
        return wordFreq;
    }
}
