package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 活字印刷
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TypePrinting
 * @apiNote </br>
 * @since 2023/5/19 9:20
 */
public class TypePrinting {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> count = new HashMap<>();
        // 记录字符出现的频率
        for (char t : tiles.toCharArray()) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        Set<Character> tile = new HashSet<>(count.keySet());
        return dfs(tiles.length(), count, tile)-1;
    }

    private int dfs(int length, Map<Character, Integer> count, Set<Character> tile) {
        if (length == 0) {
            return 1;
        }
        int result = 1;
        for (Character t : tile) {
            if (count.get(t) > 0) {
                count.put(t, count.get(t) - 1);
                result += dfs(length - 1, count, tile);
                count.put(t, count.get(t) + 1);
            }
        }
        return result;
    }
}
