package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 242. 有效的字母异位词
 *
 * @author gewuyou
 * @since 2024-04-09 下午5:03:04
 */
public class ValidAlphabeticWords {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char d = t.charAt(i);
            tMap.put(d, tMap.getOrDefault(d, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            Character key = entry.getKey();
            if (!Objects.equals(tMap.get(key), entry.getValue())) {
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            Character key = entry.getKey();
            if (!Objects.equals(sMap.get(key), entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
