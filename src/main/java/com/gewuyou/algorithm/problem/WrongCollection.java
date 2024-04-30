package com.gewuyou.algorithm.problem;

/**
 * 645. 错误的集合
 *
 * @author gewuyou
 * @since 2024-04-26 上午10:04:09
 */
public class WrongCollection {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1];
        int duplicate = -1;

        int total = n * (n + 1) / 2;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            count[num]++;
            if (count[num] > 1) {
                duplicate = num;
            }
        }
        int diff = total - sum;
        return new int[]{duplicate,  duplicate + diff};
    }
}

