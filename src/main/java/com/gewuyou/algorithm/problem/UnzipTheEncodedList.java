package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1313. 解压缩编码列表
 *
 * @author gewuyou
 * @since 2024-05-23 下午3:23:07
 */
public class UnzipTheEncodedList {
    public int[] decompressRLElist(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            int count = nums[i];
            int value = nums[i + 1];
            for (int j = 0; j < count; j++) {
                result.add(value);
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
