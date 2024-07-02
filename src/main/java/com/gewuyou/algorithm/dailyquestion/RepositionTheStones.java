package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2766. 重新放置石块
 *
 * @author gewuyou
 * @since 2024-07-24 下午12:35:41
 */
public class RepositionTheStones {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        int m = moveTo.length;
        Map<Integer, Boolean> map = new HashMap<>();
        for (int j : nums) {
            map.put(j, true);
        }
        for (int i = 0; i < m; i++) {
            map.remove(moveFrom[i]);
            map.put(moveTo[i], true);
        }
        return map.entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .sorted()
                .toList();
    }
}
