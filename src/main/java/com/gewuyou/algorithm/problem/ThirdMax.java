package com.gewuyou.algorithm.problem;

import java.util.TreeSet;

/**
 * 414. 第三大的数
 *
 * @author gewuyou
 * @since 2024-04-16 上午9:35:33
 */
public class ThirdMax {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() == 3? set.first() : set.last();
    }

}
