package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 *
 * @author gewuyou
 * @since 2024-04-26 下午2:48:22
 */
public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序，使重复元素相邻
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, ArrayList<Integer> objects, List<List<Integer>> result) {
        result.add(new ArrayList<>(objects));
        for (int i = index; i < nums.length; i++) {
            // 剪枝去除重复情况，如果当前元素与前一个元素相同且不是第一个元素，则跳过
            if(i>index && nums[i] == nums[i-1]){
                continue;
            }
            objects.add(nums[i]);
            backtrack(nums, i + 1, objects, result);
            objects.remove(objects.size() - 1);
        }
    }


}
