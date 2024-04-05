package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 *
 * @author gewuyou
 * @since 2024-04-16 下午2:23:25
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}
