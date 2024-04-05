package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author gewuyou
 * @since 2024-04-15 下午2:59:59
 */
public class FullyArranged {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), result, 0);
        return result;
    }

    private void backtrack(int[] nums, ArrayList<Integer> result, List<List<Integer>> results, int index) {
        if (index == nums.length) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = index; i < nums.length; i++) {
           // 交换元素
            exchange(nums, index, i);
            result.add(nums[index]);
            backtrack(nums, result, results, index + 1);
            // 恢复交换
            result.remove(result.size() - 1);
            exchange(nums, index, i);
        }
    }

    /**
     * 交换array数组中索引i处与索引j处的值
     *
     * @param array 数组
     * @param i     索引
     * @param j     索引
     * @apiNote
     * @since 2022/9/11 13:57
     */
    public void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
