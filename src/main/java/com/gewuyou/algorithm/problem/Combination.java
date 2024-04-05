package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * @author gewuyou
 * @since 2024-04-22 下午2:21:21
 */
public class Combination {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        recursion(results, new ArrayList<>(), 1, n, k);
        return results;
    }

    private void recursion(List<List<Integer>> results, ArrayList<Integer> result, int index, int length, int count) {
        if (count == 0) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = index; i <= length; i++) {
            result.add(i);
            recursion(results, result, i + 1, length, count - 1);
            result.remove(result.size() - 1);
        }
    }
}
