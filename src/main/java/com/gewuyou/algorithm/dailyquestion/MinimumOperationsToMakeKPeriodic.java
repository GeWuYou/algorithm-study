package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 3137. K 周期字符串需要的最少操作次数
 *
 * @author gewuyou
 * @since 2024-08-17 09:29:09
 */
public class MinimumOperationsToMakeKPeriodic {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int n = word.length();
        int count = n / k;
        // 按照k个周期分割字符串
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i += k) {
            String s = word.substring(i, i + k);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int value = 0;
        for (Integer i : map.values()) {
            value = Math.max(value, i);
        }
        return count - value;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeKPeriodic m = new MinimumOperationsToMakeKPeriodic();
        System.out.println(m.minimumOperationsToMakeKPeriodic("anat", 2));
    }
}
