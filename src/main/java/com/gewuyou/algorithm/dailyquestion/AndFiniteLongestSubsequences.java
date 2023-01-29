package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 和有限的最长子序列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName AndFiniteLongestSubsequences
 * @apiNote </br>
 * @since 2023/3/17 9:12
 */
public class AndFiniteLongestSubsequences {
    public int[] answerQueries(int[] nums, int[] queries) {
        int numsLength = nums.length;
        int queriesLength = queries.length;
        // 对nums进行排序
        Arrays.sort(nums);
        // 记录前缀和
        int[] prefixAnd = new int[numsLength + 1];
        // 计算前缀和
        for (int i = 0; i < numsLength; i++) {
            prefixAnd[i + 1] = prefixAnd[i] + nums[i];
        }
        // 创建结果数组
        int[] result = new int[queriesLength];
        for (int j = 0; j < queriesLength; j++) {
            result[j] = binarySearch(prefixAnd, queries[j]) - 1;
        }
        return result;
    }

    public int binarySearch(int[] f, int target) {
        int low = 1;
        int high = f.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (f[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
