package com.gewuyou.algorithm.dailyquestion;

import java.util.HashSet;
import java.util.Set;

/**
 * 检查相同字母间的距离
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName CheckTheDistanceBetweenTheSameLetters
 * @apiNote </br>
 * @since 2023/4/9 23:04
 */
public class CheckTheDistanceBetweenTheSameLetters {
    public static boolean checkDistancesBak(String s, int[] distance) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            try {
                if (set.add(letter) && letter != s.charAt(i + distance[letter - 'a'])) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkDistances(String s, int[] distance) {
        int[] firstIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int dis = s.charAt(i) - 'a';
            // 出现过才检查
            if (firstIndex[dis] != 0 && i - distance[dis] != firstIndex[dis]) {
                return false;
            }
            firstIndex[dis] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aa";
        int[] distance = new int[]{1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(checkDistances(s, distance));
    }
}
