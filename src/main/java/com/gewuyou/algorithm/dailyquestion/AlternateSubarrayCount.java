package com.gewuyou.algorithm.dailyquestion;

/**
 * 3101. 交替子数组计数
 *
 * @author gewuyou
 * @since 2024-07-06 上午8:52:48
 */
public class AlternateSubarrayCount {
    public long countAlternatingSubarrays(int[] nums) {
        long result = 0;
        long count = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if(nums[i] != nums[i-1]){
                count++;
            }else{
                result += count * (count + 1) / 2;
                count = 1;
            }
        }
        if(count!= 0){
            result += count * (count + 1) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        AlternateSubarrayCount solution = new AlternateSubarrayCount();
        System.out.println(solution.countAlternatingSubarrays(new int[]{0,1,0,1}));
    }
}
