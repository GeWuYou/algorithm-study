package com.gewuyou.algorithm.dailyquestion;

import java.util.HashSet;
import java.util.Set;

/**
 * 使数组中所有元素都等于零
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MakeAllElementsInTheArrayEqualToZero
 * @apiNote </br>
 * @since 2023/2/24 8:29
 */
public class MakeAllElementsInTheArrayEqualToZero {
    public static int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }
}
