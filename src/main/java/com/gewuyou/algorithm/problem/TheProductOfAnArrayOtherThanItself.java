package com.gewuyou.algorithm.problem;

/**
 * 238. 除自身以外数组的乘积
 *
 * @author gewuyou
 * @since 2024-07-27 上午9:32:48
 */
public class TheProductOfAnArrayOtherThanItself {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int [] prefixProducts = new int[n];
        int [] suffixProducts = new int[n];
        prefixProducts[0] = 1;
        suffixProducts[n-1] = 1;
        // 计算前缀积和后缀积
        for (int i = 1; i < n; i++) {
            prefixProducts[i] = prefixProducts[i-1] * nums[i-1];
            suffixProducts[n-1-i] = suffixProducts[n-i] * nums[n-i];
        }
        // 计算结果
        for (int i = 0; i < n; i++) {
            result[i] = prefixProducts[i] * suffixProducts[i];
        }
        return result;
    }
}
