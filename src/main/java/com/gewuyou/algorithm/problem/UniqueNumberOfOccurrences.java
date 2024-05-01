package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1207. 独一无二的出现次数
 *
 * @author gewuyou
 * @since 2024-05-19 上午10:40:12
 */
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set= new HashSet<>(map.values());
        return set.size() == map.size();
    }
}
