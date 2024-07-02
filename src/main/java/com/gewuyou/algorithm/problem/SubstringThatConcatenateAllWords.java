package com.gewuyou.algorithm.problem;

import java.util.*;

/**
 * 30. 串联所有单词的子串
 *
 * @author gewuyou
 * @since 2024-07-29 上午9:41:40
 */
public class SubstringThatConcatenateAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }

        int n = s.length();
        int m = words.length;
        int k = words[0].length();
        // 子串总长度
        int totalLength = m * k;
        // 如果字符串长度比子串还长，则直接返回空集合
        if (n < totalLength) {
            return result;
        }

        // 记录单词出现次数
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 保证子串都被扫描一遍，防止出现漏掉的情况
        for (int i = 0; i < k; i++) {
            int left = i, right = i, count = 0;
            // 临时窗口
            Map<String, Integer> window = new HashMap<>();
            // 按照子串步长位移
            while (right + k <= n) {
                // 截取右指针字符串偏移量
                String word = s.substring(right, right + k);
                // 右指针右移
                right += k;
                // 如果字符串子串出现在子串集合中
                if (wordCount.containsKey(word)) {
                    // 统计次数
                    window.put(word, window.getOrDefault(word, 0) + 1);
                    // 计数器加一
                    count++;
                    // 如果窗口中子串出现的次数大于目标子串集合中次数，则左指针右移
                    while (window.get(word) > wordCount.get(word)) {
                        // 截取左指针子串偏移量
                        String leftWord = s.substring(left, left + k);
                        // 出现次数减一
                        window.put(leftWord, window.get(leftWord) - 1);
                        // 移动左指针
                        left += k;
                        // 计数器减一
                        count--;
                    }
                    // 如果窗口中子串出现的次数等于目标子串集合中次数，则找到子串，记录出现位置
                    if (count == m) {
                        result.add(left);
                    }
                }
                // 如果字符串子串不在子串集合中，则清空窗口，计数器，将左指针移动到右指针位置
                else {
                    window.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaa";
        String[] words = {"aa", "aa"};
        SubstringThatConcatenateAllWords solution = new SubstringThatConcatenateAllWords();
        List<Integer> result = solution.findSubstring(s, words);
        System.out.println(result);
    }
}
