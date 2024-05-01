package com.gewuyou.algorithm.dailyquestion;

/**
 * 1013. 将数组分成和相等的三个部分
 *
 * @author gewuyou
 * @since 2024-05-13 下午3:27:48
 */
public class DivideTheArrayIntoThreeEqualParts {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int target = sum / 3;
        int count = 0;
        sum = 0;
        for (int i : arr) {
            sum += i;
            if (sum == target) {
                count++;
                sum = 0;
            }
        }
        return count >= 3;
    }
}
