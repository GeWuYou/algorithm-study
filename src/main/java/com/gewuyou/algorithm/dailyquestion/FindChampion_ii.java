package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 找到冠军 II
 *
 * @author gewuyou
 * @since 2024-04-13 上午9:23:19
 */
public class FindChampion_ii {
    public int findChampion(int n, int[][] edges) {
        List<Integer> champion = new ArrayList<>();
        // 记录队伍
        int[] team = new int[n];
        for (int[] edge : edges) {
            team[edge[1]]++;
        }
        // 找出度为0的节点
        for (int i = 0; i < team.length; i++) {
            if (team[i] == 0) {
                if (champion.isEmpty()) {
                    champion.add(i);
                } else {
                    return -1;
                }
            }
        }
        return champion.get(0);
    }
}
