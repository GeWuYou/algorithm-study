package com.gewuyou.algorithm.dailyquestion;

/**
 * 生成平衡数组的方案数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NumberOfSchemesToGenerateABalancedArray
 * @apiNote </br>
 * @since 2023/1/28 15:12
 */
public class NumberOfSchemesToGenerateABalancedArray {
    public int waysToMakeFair(int[] nums) {
        // 前奇数和与偶数和
        int preOddSum = 0;
        int preEvenSum = 0;
        // 后奇数和偶数和
        int nextOddSum = 0;
        int nextEvenSum = 0;

        // 计算初始化的和
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) != 0) {
                nextOddSum += nums[i];
            } else {
                nextEvenSum += nums[i];
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {

            if ((i & 1) != 0) {
                // 删除奇数
                nextOddSum -= nums[i];
            } else {
                // 删除偶数
                nextEvenSum -= nums[i];
            }
            // 删除元素后，前面的奇数和与偶数和不变，但后面的奇数和变为偶数和，而偶数和变为了奇数和
            if (preOddSum + nextEvenSum == nextOddSum + preEvenSum) {
                result++;
            }
            // 将删除后的数据加入前奇数或者前偶数和中
            if ((i & 1) != 0) {
                // 加入奇数
                preOddSum += nums[i];

            } else {
                // 加入偶数
                preEvenSum += nums[i];

            }
        }
        return result;
    }
}
