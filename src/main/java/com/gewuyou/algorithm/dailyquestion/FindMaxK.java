package com.gewuyou.algorithm.dailyquestion;

import java.util.HashSet;
import java.util.Set;

/**
 * 与对应负数同时存在的最大正整数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FindMaxK
 * @apiNote </br>
 * @since 2023/5/13 16:30
 */
public class FindMaxK {
    public int findMaxK(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            // 遍历数组，判断该值是否存在，如果存在则进行比较，反之将其相反数加入
            if (set.contains(num)) {
                max = Math.max(Math.abs(num), max);
            } else {
                set.add(-num);
            }
        }
        return max==0?-1:max;
    }
}
