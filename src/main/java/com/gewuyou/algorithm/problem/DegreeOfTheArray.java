package com.gewuyou.algorithm.problem;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 *
 * @author gewuyou
 * @since 2024-04-28 下午4:34:22
 */
public class DegreeOfTheArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        Map<Integer, Integer[]> locales = new HashMap<>();
        // 统计数量
        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
            if (locales.containsKey(nums[i])) {
                locales.get(nums[i])[1] = i;
            } else {
                locales.put(nums[i], new Integer[]{i, i});
            }
        }
        // 找到最多的数
        int maxKey = 0;
        int maxValue = 0;
        int minCount = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            Integer value = entry.getValue();
            if (maxValue < value) {
                maxValue = value;
                maxKey = entry.getKey();
                Integer[] maxLocales = locales.get(maxKey);
                minCount = maxLocales[1] - maxLocales[0] + 1;
            } else if (maxValue == value) {
                Integer[] entryLocales = locales.get(entry.getKey());
                Integer[] maxLocales = locales.get(maxKey);
                int m = maxLocales[1] - maxLocales[0] + 1;
                int e = entryLocales[1] - entryLocales[0] + 1;
                if (m > e) {
                    maxKey = entry.getKey();
                    minCount = e;
                }
            }
        }
        return minCount;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        DegreeOfTheArray solution = new DegreeOfTheArray();
        int shortestSubArray = solution.findShortestSubArray(nums);
        System.out.println(shortestSubArray);
    }
}
