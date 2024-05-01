package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. 可被 5 整除的二进制前缀
 *
 * @author gewuyou
 * @since 2024-05-14 下午12:58:41
 */
public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int prefix = 0;
        for (int num : nums) {
            // 计算当前数字的二进制表示并判断是否能够被5整除
            prefix = (prefix * 2 + num) % 5;
            result.add(prefix == 0);
        }
        return result;
    }
}
