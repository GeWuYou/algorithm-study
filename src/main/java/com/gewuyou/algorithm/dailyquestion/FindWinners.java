package com.gewuyou.algorithm.dailyquestion;

import java.util.*;

/**
 * 2225. 找出输掉零场或一场比赛的玩家
 *
 * @author gewuyou
 * @since 2024-05-22 上午11:23:18
 */
public class FindWinners {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            // 更新胜者数据
            if(!map.containsKey(winner)){
                map.put(winner, 0);
            }
            // 更新败者数据
            int orDefault = map.getOrDefault(loser, 0);
            map.put(loser, orDefault + 1);
        }
        // 找出输掉零场或一场比赛的玩家
        List<Integer> zeroWinners = new ArrayList<>();
        List<Integer> oneWinners = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                zeroWinners.add(entry.getKey());
            }

            if (entry.getValue() == 1) {
                oneWinners.add(entry.getKey());
            }
        }
        Collections.sort(zeroWinners);
        Collections.sort(oneWinners);
        List<List<Integer>> result = new ArrayList<>();
        result.add(zeroWinners);
        result.add(oneWinners);
        return result;
    }
}
