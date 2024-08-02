package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LCR 083. 全排列
 *
 * @author gewuyou
 * @since 2024-08-05 下午5:22:45
 */
public class FullyArrangedLCR {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, res, new ArrayList<>(), 0);
        return res;
    }

    private void f(int[] nums, List<List<Integer>> res, List<Integer> result, int start) {
        if (start == nums.length) {
            res.add(new ArrayList<>(result));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 交换
            exchange(nums,start,i);
            result.add(nums[start]);
            f(nums, res, result, start + 1);
            // 恢复交换
            result.removeLast();
            exchange(nums,start,i);
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
        if(i==j){
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
