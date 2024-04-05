package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 电话号码的字母组合
 *
 * @author gewuyou
 * @since 2024-04-09 下午5:36:02
 */
public class LetterCombinationOfThePhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        Map<Character, String> phoneMap = Map.of(
                '2', "abc",
                '3', "def",
                '4', "ghi",
                '5', "jkl",
                '6', "mno",
                '7', "pqrs",
                '8', "tuv",
                '9', "wxyz"
        );
        recursion(result, digits, phoneMap, 0, new StringBuilder());
        return result;
    }

    private void recursion(List<String> result, String digits, Map<Character, String> phoneMap, int index, StringBuilder stringBuilder) {
        if (index == digits.length()) {
            result.add(stringBuilder.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                stringBuilder.append(letters.charAt(i));
                recursion(result, digits, phoneMap, index + 1, stringBuilder);
                stringBuilder.deleteCharAt(index);
            }
        }
    }
}
