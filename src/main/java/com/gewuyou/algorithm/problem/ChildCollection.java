package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * @author gewuyou
 * @since 2024-04-22 下午3:38:41
 */
public class ChildCollection {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return results;
        }
        backtrack(nums, 0, new ArrayList<>(), results);
        return results;
    }

    private void backtrack(int[] nums, int index, List<Integer> result, List<List<Integer>> results){
        results.add(new ArrayList<>(result));
        for(int i = index; i < nums.length; i++){
            result.add(nums[i]);
            backtrack(nums, i + 1, result, results);
            result.remove(result.size() - 1);
        }
    }
}
