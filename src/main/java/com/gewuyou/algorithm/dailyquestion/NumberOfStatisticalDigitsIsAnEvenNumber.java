package com.gewuyou.algorithm.dailyquestion;

/**
 * 1295. 统计位数为偶数的数字
 *
 * @author gewuyou
 * @since 2024-05-22 下午12:02:28
 */
public class NumberOfStatisticalDigitsIsAnEvenNumber {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((String.valueOf(num).length() &1)==0) {
                count++;
            }
        }
        return count;
    }
}
