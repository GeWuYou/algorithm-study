package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 缺失的数字
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MissingNumber
 * @apiNote </br>
 * @since 2023/1/22 18:08
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int index = 0;
        for (index = 0; index < nums.length; index++) {
            if(nums[index]!=index){
                return index;
            }
        }
        return index;
    }
}
