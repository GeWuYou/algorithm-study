package com.gewuyou.algorithm.problem;

/**
 * 最后一个单词的长度
 *
 * @author gewuyou
 * @since 2024-04-05 下午3:01:28
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // 去除前后空格
        s = s.trim();
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}
