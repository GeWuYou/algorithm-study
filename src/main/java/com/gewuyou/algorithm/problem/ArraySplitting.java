package com.gewuyou.algorithm.problem;

import java.util.Arrays;

/**
 * 561. 数组拆分
 *
 * @author gewuyou
 * @since 2024-04-22 下午2:08:43
 */
public class ArraySplitting {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if((i&1)==0){
                max+=nums[i];
            }
        }
        return max;
    }
}
