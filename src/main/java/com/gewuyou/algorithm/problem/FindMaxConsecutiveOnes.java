package com.gewuyou.algorithm.problem;

/**
 * 485. 最大连续 1 的个数
 *
 * @author gewuyou
 * @since 2024-04-18 下午3:35:00
 */
public class FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int num : nums) {
            if(num == 1){
                count++;
            }else{
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(max, count);
    }
}
