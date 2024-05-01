package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 914. 卡牌分组
 *
 * @author gewuyou
 * @since 2024-05-08 下午12:21:28
 */
public class CardGrouping {
    public boolean hasGroupsSizeX(int[] deck) {
        // 使用哈希表统计每个数出现的次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : deck) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        // 计算最大公约数
        int maxGcd = 0;
        for (int count : countMap.values()) {
            maxGcd = gcd(maxGcd, count);
        }
        return maxGcd >= 2;

    }
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
