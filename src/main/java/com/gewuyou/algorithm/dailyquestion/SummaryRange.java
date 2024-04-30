package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总区间
 *
 * @author gewuyou
 */
public class SummaryRange {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int length = nums.length;
        while (i < length) {
            int start = i;
            i++;
            while (i < length && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int end = i - 1;
            StringBuilder sb = new StringBuilder();
            sb.append(nums[start]);
            // 如果start<end说明是区间
            if (start < end) {
                sb.append("->").append(nums[end]);
            }
            // 如果start>end说明是单个数字
            result.add(sb.toString());
        }
        return result;
    }
}
