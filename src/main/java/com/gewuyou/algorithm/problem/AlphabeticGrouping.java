package com.gewuyou.algorithm.problem;

import java.util.*;

/**
 * 49. 字母异位词分组
 *
 * @author gewuyou
 * @since 2024-04-16 下午2:56:21
 */
public class AlphabeticGrouping {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }

}
