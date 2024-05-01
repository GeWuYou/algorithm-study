package com.gewuyou.algorithm.dailyquestion;

/**
 * 2903. 找出满足差值条件的下标 I
 *
 * @author gewuyou
 * @since 2024-05-25 上午11:31:33
 */
public class FindIndices {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        while (i<n&&j<n) {
            if(Math.abs(i-j)>=indexDifference && Math.abs(nums[i]-nums[j])>=valueDifference){
                return new int[]{i,j};
            }
            j++;
            if(j>=n){
                i++;
                j=i+1;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {

        int[] nums = {0,0};
        int indexDifference = 1;
        int valueDifference = 1;
        FindIndices fi = new FindIndices();
        int[] res = fi.findIndices(nums, indexDifference, valueDifference);
        System.out.println(res[0]+" "+res[1]);
    }
}
