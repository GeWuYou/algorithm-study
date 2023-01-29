package com.gewuyou.algorithm.dailyquestion;

import java.util.HashSet;
import java.util.Set;

/**
 * 兼具大小写的最好英文字母
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName GreatestLetter
 * @apiNote </br>
 * @since 2023/1/27 13:37
 */
public class GreatestLetter {
    public String greatestLetter(String s) {
        Set<Character> letter = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            letter.add(s.charAt(i));
        }
        for (int i = 0; i < 26; i++) {
            if (letter.contains((char)('Z' - i)) && letter.contains((char)('z' - i))) {
                char result = (char) ('Z' - i);
                return Character.toString(result);
            }
        }
        return "";
    }
}
