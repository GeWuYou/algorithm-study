package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2831. 找出最长等值子数组
 *
 * @author gewuyou
 * @since 2024-05-23 下午1:47:23
 */
public class FindTheLongestSubarrayOfEquivalents {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        // 使用map记录每个元素及其出现的所有索引
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 将nums中的元素和其索引添加到map中
            map.computeIfAbsent(nums.get(i), x -> new ArrayList<>()).add(i);
        }
        int ans = 0;
        // 遍历map中每个元素对应的索引列表
        for (List<Integer> value : map.values()) {
            // 使用双指针来找到最长的等值子数组
            for (int i = 0, j = 0; i < value.size(); i++) {
                // 检查当前子数组中的索引差与元素个数差是否超过k
                while (value.get(i) - value.get(j) - (i - j) > k) {
                    // 如果超过k，移动左指针j
                    j++;
                }
                // 更新最大长度
                ans = Math.max(ans, i - j + 1);
            }
        }
        return ans;
    }
}
