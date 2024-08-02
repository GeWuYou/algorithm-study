package com.gewuyou.algorithm.dailyquestion;

/**
 * 3151. 特殊数组 I
 *
 * @author gewuyou
 * @since 2024-08-13 10:14:30
 */
public class SpecialArrayI {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        int pre = nums[0];
        if(n==1){
            return true;
        }
        for (int i = 1; i < n; i++) {
            boolean isPreOdd = (pre&1)==1;
            boolean isCurrOdd = (nums[i]&1)==1;
            if(isCurrOdd==isPreOdd){
                return false;
            }
            pre = nums[i];
        }
        return true;
    }
}
