package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 存在重复元素2
 *
 * @author gewuyou
 * @since 2024-04-08 下午12:33:01
 */
public class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap<>();
       for (int i = 0; i < nums.length; i++) {
           int num = nums[i];
           if (map.containsKey(num) && i - map.get(num) <= k) {
               return true;
           }
           map.put(num, i);
       }

       return false;
    }
}
