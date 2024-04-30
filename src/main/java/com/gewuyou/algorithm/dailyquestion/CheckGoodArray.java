package com.gewuyou.algorithm.dailyquestion;

/**
 * 检查好数组
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName CheckGoodArray
 * @apiNote </br>
 * @since 2023/2/15 20:07
 */
public class CheckGoodArray {
    public boolean isGoodArray(int[] nums) {
        int maxDivisor = nums[0];
        for (int num : nums) {
            maxDivisor = tossingAndTurning(maxDivisor, num);
            if (maxDivisor == 1) {
                return true;
            }
        }
        return maxDivisor == 1;
    }

    /**
     * 辗转相除法
     *
     * @param number1 数字1
     * @param number2 数字2
     * @return int 最大公约数
     * @apiNote 使用辗转相除法求最大公约数
     * @since 2023/2/15 20:22
     */
    public int tossingAndTurning(int number1, int number2) {
        while (number2 != 0) {
            // 事先记录number1
            int temp = number1;
            // 交换二者
            number1 = number2;
            // 求余
            number2 = temp % number1;
        }
        return number1;
    }
}
