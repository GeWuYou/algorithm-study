package com.gewuyou.algorithm.dailyquestion;

import java.util.HashSet;
import java.util.Set;

/**
 * 和相等的子数组
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName AndEqualSubarrays
 * @apiNote </br>
 * @since 2023/3/26 11:34
 */
public class AndEqualSubarrays {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (!set.add(sum)) {
                return true;
            }
        }
        return false;
    }
}
