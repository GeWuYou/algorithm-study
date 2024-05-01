package com.gewuyou.algorithm.problem;

/**
 * 821. 字符的最短距离
 *
 * @author gewuyou
 * @since 2024-05-03 下午2:58:46
 */
public class ShortestDistanceOfTheCharacter {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] result = new int[n];

        int index = s.indexOf(c);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                index = i;
            }
            result[i] = Math.abs(i - index);
        }
        index = s.lastIndexOf(c);
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                index = i;
            }
            result[i] = Math.min(result[i], Math.abs(i - index));
        }
        return result;
    }
}
