package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. 多数元素 II
 *
 * @author gewuyou
 * @since 2024-07-23 上午10:37:42
 */
public class MostElementII {
    public List<Integer> majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int n = nums.length / 3;
            List<Integer> result = new ArrayList<>();
            for (int num : map.keySet()) {
                if (map.get(num) > n) {
                    result.add(num);
                }
            }
            return result;
    }
}
