package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;

/**
 * 数组和能被 P 整除
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TheSumOfArraysIsDivisibleByP
 * @apiNote </br>
 * @since 2023/3/10 13:20
 */
public class TheSumOfArraysIsDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        int length = nums.length;
        int result = length;
        int[] s = new int[length + 1];
        // 构建前缀和
        for (int i = 0; i < length; i++) {
            s[i + 1] = (s[i] + nums[i]) % p;
        }
        int x = s[length];
        // 移除空子数组
        if (x == 0) {
            return 0;
        }
        HashMap<Integer, Integer> last = new HashMap<Integer, Integer>();
        for (int i = 0; i <= length; i++) {
            last.put(s[i], i);
            int j = last.getOrDefault((s[i] - x + p) % p, -length);
            result = Math.min(result, i - j);
        }
        return result < length ? result : -1;
    }
}
