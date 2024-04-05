package com.gewuyou.algorithm.problem;

import java.util.Set;

/**
 * 345. 反转字符串中的元音字母
 *
 * @author gewuyou
 * @since 2024-04-12 下午1:53:55
 */
public class ReverseVowels {
    public String reverseVowels(String s) {
        Set<Character> characters = Set.of(
                'a', 'e', 'i', 'o', 'u','A','E','I','O','U'
        );
        int n = s.length();
        int l = 0, r = n - 1;
        char[] array = s.toCharArray();
        while (l < r) {
            if (characters.contains(array[l]) && characters.contains(array[r])) {
                char temp = array[r];
                array[r] = array[l];
                array[l] = temp;
                r--;
                l++;
            }
            if(!characters.contains(array[l]) ){
                l++;
            }
            if(!characters.contains(array[r]) ){
                r--;
            }
        }
        return String.valueOf(array);
    }
}
