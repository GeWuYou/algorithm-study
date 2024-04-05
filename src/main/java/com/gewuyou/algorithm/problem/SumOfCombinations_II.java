package com.gewuyou.algorithm.problem;

import java.util.*;

/**
 * 40. 组合总和 II
 *
 * @author gewuyou
 * @since 2024-04-13 上午11:21:01
 */
public class SumOfCombinations_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        // 排序传入数组
        Arrays.sort(candidates);
        recursion(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    private void recursion(List<List<Integer>> results, ArrayList<Integer> result, int[] candidates, int target, int index) {
        if (target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < candidates.length; i++) {
            int newTarget = target - candidates[i];
            // 如果当前元素大于目标值，则跳过
            if (newTarget < 0) {
                continue;
            }
            // 如果在Set中已经存在当前元素，则跳过
            if (set.add(candidates[i])) {
                result.add(candidates[i]);
                recursion(results, result, candidates, newTarget, i+ 1);
                result.remove(result.size() - 1);
            }
        }
    }
}
