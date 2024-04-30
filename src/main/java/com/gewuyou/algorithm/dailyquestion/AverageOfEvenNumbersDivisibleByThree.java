package com.gewuyou.algorithm.dailyquestion;

/**
 * 可被三整除的偶数的平均值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName AverageOfEvenNumbersDivisibleByThree
 * @apiNote </br>
 * @since 2023/5/29 13:19
 */
public class AverageOfEvenNumbersDivisibleByThree {
    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        return count==0?0:sum / count;
    }
}
