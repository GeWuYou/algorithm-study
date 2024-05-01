package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 997. 找到小镇的法官
 *
 * @author gewuyou
 * @since 2024-05-12 下午2:32:52
 */
public class FindTheJudgeInTheTown {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> trustMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            trustMap.put(i, 0);
        }
        Set<Integer> set = new HashSet<>();
        for (int[] t : trust) {
            set.add(t[0]);
            trustMap.put(t[1], trustMap.get(t[1]) + 1);
        }
        // 移除必定不是法官的人
        trustMap.entrySet().removeIf(entry -> set.contains(entry.getKey()));
        // 找到唯一的法官
        for (Map.Entry<Integer, Integer> entry : trustMap.entrySet()) {
            if (entry.getValue() == n-1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
