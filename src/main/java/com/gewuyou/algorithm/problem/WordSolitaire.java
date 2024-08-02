package com.gewuyou.algorithm.problem;

import java.util.*;

/**
 * 127. 单词接龙
 *
 * @author gewuyou
 * @since 2024-08-06 上午8:27:41
 */
public class WordSolitaire {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        // 设置一个字母表
        char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        // 判断wordSet中是否含有endWord
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        // 将起始字符串加入队列
        queue.offer(beginWord);
        visited.add(beginWord);
        // 记录广度优先遍历的层数
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                // 判断是否到达终点
                if (endWord.equals(word)) {
                    return level;
                }
                // 将字符串转为字符数组
                char[] wordCharArray;
                if (word != null) {
                    wordCharArray = word.toCharArray();
                } else {
                    continue;
                }
                // 遍历word的所有可能的变换
                for (int j = 0; j < wordCharArray.length; j++) {
                    char originChar = wordCharArray[j];
                    // 遍历所有可能的字母
                    for (char newChar : letters) {
                        // 跳过原字母
                        if (originChar == newChar) {
                            continue;
                        }
                        // 尝试将原来的字母变为新字母
                        wordCharArray[j] = newChar;
                        String newWord = new String(wordCharArray);
                        // 判断是否在wordSet中
                        if (wordSet.contains(newWord) && visited.add(newWord)) {
                            queue.offer(newWord);
                        }
                    }
                    // 恢复原来的字母
                    wordCharArray[j] = originChar;
                }
            }
        }
        return 0;
    }
}
