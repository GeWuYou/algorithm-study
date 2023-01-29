package com.gewuyou.algorithm.dailyquestion;

/**
 * 算术三元组的数目
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName NumberOfArithmeticTriples
 * @apiNote </br>
 * @since 2023/3/31 12:36
 */
public class NumberOfArithmeticTriples {
    /**
     * 暴力解
     *
     * @since 2023/3/31 12:48
     */
    public int arithmeticTripletsBak(int[] nums, int diff) {
        int length = nums.length;
        int result = 0;
        for (int k = length - 1; k >= 0; k--) {
            for (int i : nums) {
                if (nums[k] - i == diff) {
                    for (int num : nums) {
                        if (i - num == diff) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        int length = nums.length;
        int result = 0;
        for (int i = 0, j = 1, k = 2; i < length - 2 && j < length - 1 && k < length; i++) {
            // 如果j<=i则将j更新为i+1
            j = Math.max(j, i + 1);
            while (j < (length - 1) && nums[j] - nums[i] < diff) {
                j++;
            }
            if (j > length - 1 || nums[j] - nums[i] > diff) {
                continue;
            }
            k = Math.max(k, j + 1);
            while (k < (length - 1) && nums[k] - nums[j] < diff) {
                k++;
            }
            if (k < length && nums[k] - nums[j] == diff) {
                result++;
            }

        }
        return result;
    }
}
