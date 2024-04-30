package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * @author gewuyou
 * @since 2024-04-21 上午10:05:47
 */
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;

    }

    private void backtrack(List<List<Integer>> results, List<Integer> result, int index, int target, int count) {
        if(target!=0 && count == 0){
            return;
        }
        if (target == 0&& count == 0) {
            results.add(new ArrayList<>(result));
        }
        for (int i = index; i <= 9; i++) {
          // 计算新目标值
            int newTarget = target - i;
            result.add(i);
            backtrack(results, result, i + 1, newTarget, count-1);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 solution = new CombinationSum3();
        List<List<Integer>> result = solution.combinationSum3(3, 7);
        System.out.println(result);
    }
}
