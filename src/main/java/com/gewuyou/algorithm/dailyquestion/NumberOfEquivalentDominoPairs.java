package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 1128. 等价多米诺骨牌对的数量
 *
 * @author gewuyou
 * @since 2024-05-17 下午6:46:14
 */
public class NumberOfEquivalentDominoPairs {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        // 用于记录每种骨牌对的计数
        int[] cp = new int[100];
        for (int[] arr : dominoes) {
            // 对每个骨牌对进行排序，确保 [a, b] 和 [b, a] 被视为相同的键
            Arrays.sort(arr);
            // 将骨牌对转换为唯一的键并更新计数
            ans += cp[arr[0] * 10 + arr[1]]++;
        }
        return ans;
        // Map<String, Integer> countMap = new HashMap<>();
        // int res = 0;
        //
        // for (int[] domino : dominoes) {
        //     int a = domino[0];
        //     int b = domino[1];
        //     // 对配对进行排序，以确保 [a， b] 和 [b， a] 的处理方式相同
        //     String key = a < b ? a + "," + b : b + "," + a;
        //     countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        // }
        //
        // for (int count : countMap.values()) {
        //     // 对于每对，计算等效多米诺骨牌对的数量
        //     if (count > 1) {
        //         res += count * (count - 1) / 2;
        //     }
        // }
        //
        // return res;
    }
}
