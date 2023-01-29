package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组能形成多少数对
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ArraysCanFormManyMinorityPairs
 * @apiNote </br>
 * @since 2023/2/16 9:59
 */
public class ArraysCanFormManyMinorityPairs {
    public int[] numberOfPairs(int[] nums) {
        // 记录出现数对
        int result = 0;
        // 构建哈希表
        Map<Integer, Boolean> map = new HashMap<>();
        // 遍历数组
        for (int num : nums) {
            map.put(num, !map.getOrDefault(num, false));
            if(Boolean.FALSE.equals(map.get(num))){
                result++;
            }
        }
        return new int[]{result,nums.length-2*result};
    }
    public int[] numberOfPairsBak(int[] nums) {
        // 记录出现数对
        int result = 0;
        // 构建哈希表
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer temp = map.get(nums[i]);
            if(temp==null){
                map.put(nums[i],i);
            }else {
                // 删除哈希表值中值
                map.remove(nums[i]);
                result++;
            }
        }
        return new int[]{result,nums.length-2*result};
    }
}
