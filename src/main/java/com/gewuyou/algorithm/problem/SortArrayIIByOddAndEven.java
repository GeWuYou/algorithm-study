package com.gewuyou.algorithm.problem;

/**
 * 922. 按奇偶排序数组 II
 *
 * @author gewuyou
 * @since 2024-05-08 下午12:43:33
 */
public class SortArrayIIByOddAndEven {
    public int[] sortArrayByParityII(int[] nums) {
        int oddIndex= 0;
        int evenIndex = 1;
        int n = nums.length;
        while(oddIndex<n&&evenIndex<n){
            while(oddIndex<n&&(nums[oddIndex]&1)==0){
                oddIndex+=2;
            }
            while(evenIndex<n&&(nums[evenIndex]&1)==1){
                evenIndex+=2;
            }
            if(oddIndex<n&&evenIndex<n){
                int temp = nums[oddIndex];
                nums[oddIndex] = nums[evenIndex];
                nums[evenIndex] = temp;
            }
        }
        return nums;
    }
}
