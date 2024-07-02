package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 2956. 找到两个数组中的公共元素
 *
 * @author gewuyou
 * @since 2024-07-16 上午11:30:28
 */
public class LocateTheCommonElementsInBothArrays {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        int[] result = {0, 0};
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums1) {
            map1.put(i, map1.getOrDefault(i, 0) + 1);
        }
        for (int i : nums2) {
            map2.put(i, map2.getOrDefault(i, 0) + 1);
        }
        for (int i : nums1) {
            if (map2.containsKey(i)) {
                result[0]++;
            }
        }
        for (int i : nums2) {
            if (map1.containsKey(i)) {
                result[1]++;
            }
        }
        return result;
    }
}
