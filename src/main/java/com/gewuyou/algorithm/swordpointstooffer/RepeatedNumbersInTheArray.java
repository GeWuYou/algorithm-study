package com.gewuyou.algorithm.swordpointstooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中重复的数字
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RepeatedNumbersInTheArray
 * @apiNote </br>
 * @since 2023/1/20 13:31
 */
public class RepeatedNumbersInTheArray {
    /**
     * 思路一：构建哈希
     *
     * @param nums 数组
     * @return 重复数字的值
     */
    public int findRepeatNumber1(int[] nums) {
        // 构建哈希表
        Map<Integer, Integer> map = new HashMap<>();
        // 循环遍历数组，将元素加入哈希表中
        for (int num : nums) {
            if (map.get(num) != null) {
                return map.get(num);
            } else {
                map.put(num, num);
            }
        }
        return nums[0];
    }

    /**
     * 思路二：原地交换
     *
     * @param nums 数组
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        // 设置索引
        int index = 0;
        // 设置临时变量
        int temp;
        // 循环遍历数组
        while (index < nums.length) {
            if (index == nums[index]) {
                index++;
                continue;
            }
            // 如果不对应由于题目给出长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内
            if (index != nums[index]) {
                // 如果该索引处的值已经对应该索引了，则返回该值
                if (nums[index] == nums[nums[index]]) {
                    return nums[index];
                }
                // 否则直接交换
                else {
                    temp = nums[index];
                    nums[index] = nums[temp];
                    nums[temp] = temp;
                }
            }
            // 如果当前索引对应当前索引处的值，则跳过
        }
        return -1;
    }
}
