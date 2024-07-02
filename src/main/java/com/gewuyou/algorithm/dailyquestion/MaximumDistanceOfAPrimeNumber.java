package com.gewuyou.algorithm.dailyquestion;

/**
 * 3115. 质数的最大距离
 *
 * @author gewuyou
 * @since 2024-07-02 下午3:32:27
 */
public class MaximumDistanceOfAPrimeNumber {
    public int maximumPrimeDifference(int[] nums) {
        int max = 0;
        int minIndex = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (isPrime(nums[i])) {
               if(minIndex==-1){
                   minIndex=i;
               }else{
                   max = Math.max(max, i - minIndex);
               }
            }
        }
        return max;
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        if (num <= 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
