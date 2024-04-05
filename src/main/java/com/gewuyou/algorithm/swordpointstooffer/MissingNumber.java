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
        int [] arr = new int[nums.length+1];
        for (int num : nums) {
            arr[num] = num;
        }
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]==index){
                return i;
            }
        }
        return index;
    }
}
