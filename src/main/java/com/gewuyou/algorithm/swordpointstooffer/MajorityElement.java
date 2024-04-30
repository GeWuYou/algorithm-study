package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 数组中出现次数超过一半的数字
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MajorityElement
 * @apiNote </br>
 * @since 2023/2/13 23:12
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        // 票数
        int votes = 0;
        // 结果
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            // 当票数为0时，假设当前值为众数
            if (votes == 0) {
                result = num;
            }
            // 当前值等于众数票数+1
            if (num == result) {
                votes++;
            }
            // 反之票数减少
            else {
                votes--;
            }
        }
        //返回结果
        return result;
    }
}
