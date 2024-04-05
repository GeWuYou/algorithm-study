package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 500. 键盘行
 *
 * @author gewuyou
 * @since 2024-04-19 下午1:54:36
 */
public class KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> row1 = Set.of("q", "w", "e", "r", "t", "y", "u", "i", "o", "p");
        Set<String> row2 = Set.of("a", "s", "d", "f", "g", "h", "j", "k", "l");
        Set<String> row3 = Set.of("z", "x", "c", "v", "b", "n", "m");
        Set<Set<String>> rows = Set.of(row1, row2, row3);
        for (String word : words) {
            for (Set<String> row : rows) {
                int count = 0;
                int length = word.length();
                String[] strings = word.toLowerCase().split("");
                for (String string : strings) {
                    if (row.contains(string)) {
                        count++;
                    }else{
                        break;
                    }
                }
                if (count == length) {
                    result.add(word);
                }
            }
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        KeyboardRow keyboardRow = new KeyboardRow();
        String[] result = keyboardRow.findWords(words);
        for (String s : result) {
            System.out.println(s);
        }
    }
}
