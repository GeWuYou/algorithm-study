package com.gewuyou.algorithm.dailyquestion;

/**
 * 3153. 所有数对中数位不同之和
 *
 * @author gewuyou
 * @since 2024-08-30 10:12:04
 */
public class SumOfTheDigitsInAllPairs {
    public long sumDigitDifferences(int[] nums) {
        long res = 0;
        int n = nums.length;
        while (nums[0] > 0) {
            int[] cnt = new int[10];
            for (int i = 0; i < n; i++) {
                cnt[nums[i] % 10]++;
                nums[i] /= 10;
            }
            for (int i = 0; i < 10; i++) {
                res += (long) (n - cnt[i]) * cnt[i];
            }
        }
        return res / 2;
    }

    public static void main(String[] args) {
        int[] nums = {50,28,48};
        SumOfTheDigitsInAllPairs solution = new SumOfTheDigitsInAllPairs();
        System.out.println(solution.sumDigitDifferences(nums));
    }
}
