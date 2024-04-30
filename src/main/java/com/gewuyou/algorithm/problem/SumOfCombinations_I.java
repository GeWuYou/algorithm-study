package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author gewuyou
 * @since 2024-04-13 上午10:48:54
 */
public class SumOfCombinations_I {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 注：传入的数组candidates必须是升序的
        List<List<Integer>> results = new ArrayList<>();
        recursion(results, new ArrayList<>(), candidates, target, 0, 0);
        return results;
    }

    private void recursion(List<List<Integer>> results, ArrayList<Integer> result, int[] candidates, int target, int sum, int pre) {
        if (sum == target) {
            results.add(new ArrayList<>(result));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int candidate : candidates) {
            if (candidate >= pre) {
                result.add(candidate);
                recursion(results, result, candidates, target, sum + candidate, candidate);
                result.remove(result.size() - 1);
            }
        }
    }
}
