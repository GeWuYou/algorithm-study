package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 不同的平均值数目
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NumberOfDifferentAverages
 * @apiNote </br>
 * @since 2023/6/4 11:30
 */
public class NumberOfDifferentAverages {
    public int distinctAverages(int[] nums) {
        Set<Double> set = new HashSet<>();
        if(nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start<end){
            Double avg = (nums[start]+nums[end])/2.0;
            set.add(avg);
            start++;
            end--;
        }
        return set.size();
    }
}
