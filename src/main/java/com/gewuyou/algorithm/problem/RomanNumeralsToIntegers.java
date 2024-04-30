package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RomanNumeralsToIntegers
 * @apiNote </br>
 * @since 2023/4/1 21:03
 */
public class RomanNumeralsToIntegers {
    private static Map<Character, Integer> romanNums = new HashMap<>();

    static {
        romanNums.put('I', 1);
        romanNums.put('V', 5);
        romanNums.put('X', 10);
        romanNums.put('L', 50);
        romanNums.put('C', 100);
        romanNums.put('D', 500);
        romanNums.put('M', 1000);
    }

    public int romanToInt(String s) {
        int count = 0;
        int length = s.length();
        if (length == 0) {
            return count;
        }
        for (int i = 0; i < length - 1; i++) {
            int left = romanNums.get(s.charAt(i));
            int right = romanNums.get(s.charAt(i + 1));
            if (left >= right) {
                count += left;
            } else {
                count -= left;
            }
        }
        count += romanNums.get(s.charAt(length - 1));
        return count;
    }
}
