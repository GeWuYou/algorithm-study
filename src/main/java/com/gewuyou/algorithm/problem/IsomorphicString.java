package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 同构字符串
 *
 * @author gewuyou
 * @since 2024-04-07 下午6:31:22
 */
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        int length = s.length();
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            char d = t.charAt(i);
            if (smap.containsKey(c)) {
                if (smap.get(c) != d) {
                    return false;
                }
            } else {
                smap.put(c, d);
            }
            if (tmap.containsKey(d)) {
                if (tmap.get(d) != c) {
                    return false;
                }
            } else {
                tmap.put(d, c);
            }
        }
        return true;
    }
}
