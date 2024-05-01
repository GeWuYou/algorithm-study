package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 *
 * @author gewuyou
 * @since 2024-05-19 上午10:32:15
 */
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // 排序
        Arrays.sort(arr);
        // 定义最小差
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();
        // 遍历数组
        for (int i = 0; i < arr.length - 1; i++) {
            // 计算当前差值
            int diff = Math.abs(arr[i + 1] - arr[i]);
            // 如果当前差值小于最小差值，则更新最小差值和结果集
            if (diff < minDiff) {
                minDiff = diff;
                result.clear();
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == minDiff) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return result;
    }
}
