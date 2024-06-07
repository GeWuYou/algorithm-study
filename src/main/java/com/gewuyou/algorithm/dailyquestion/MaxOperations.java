package com.gewuyou.algorithm.dailyquestion;

/**
 * 3038. 相同分数的最大操作数目 I
 *
 * @author gewuyou
 * @since 2024-06-07 下午12:38:47
 */
public class MaxOperations {
    public int maxOperations(int[] nums) {
        int count = 1;
        int constNum = nums[0]+nums[1];
        for (int i = 3; i < nums.length; i+=2) {
            if(nums[i]+nums[i-1]==constNum){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
