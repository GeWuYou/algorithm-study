package com.gewuyou.algorithm.problem;

import java.util.*;

/**
 * 47. 全排列 II(有重复数字)
 *
 * @author gewuyou
 * @since 2024-04-15 下午3:12:55
 */
public class FullArrangement_II {
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), result, 0);
        return new ArrayList<>(result);
    }

    private void backtrack(int[] nums, ArrayList<Integer> result, List<List<Integer>> results, int index) {
        if (index == nums.length) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果该元素已被使用或者当前元素与上一个元素相同且上一个元素已被使用，则跳过
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            result.add(nums[i]);
            vis[i] = true;
            backtrack(nums, result, results, index + 1);
            // 回溯
            vis[i] = false;
            // 恢复交换
            result.remove(index);
        }
    }
}
