package com.gewuyou.algorithm.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. 唯一摩尔斯密码词
 *
 * @author gewuyou
 * @since 2024-05-02 下午2:17:02
 */
public class UniqueMorseCodeWord {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.setLength(0);
            for (int i = 0; i < word.length(); i++) {
                sb.append(morseCode[word.charAt(i) - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
