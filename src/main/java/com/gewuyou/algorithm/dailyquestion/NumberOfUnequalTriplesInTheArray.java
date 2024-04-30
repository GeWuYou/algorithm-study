package com.gewuyou.algorithm.dailyquestion;

/**
 * 数组中不等三元组的数目
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NumberOfUnequalTriplesInTheArray
 * @apiNote </br>
 * @since 2023/6/13 9:01
 */
public class NumberOfUnequalTriplesInTheArray {
    public int unequalTriplets(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
