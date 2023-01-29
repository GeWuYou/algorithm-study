package com.gewuyou.algorithm.swordpointstooffer;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ArrangeArrayIntoSmallestNumber
 * @apiNote </br>
 * @since 2023/2/2 15:34
 */
public class ArrangeArrayIntoSmallestNumber {
    public String minNumber(int[] nums) {
        // 将数组转换为字符串数组
        String [] numbers = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = String.valueOf(nums[i]);
        }
        // 对字符串数组进行排序
        Arrays.sort(numbers, (o1, o2) -> (o1+o2).compareTo(o2+o1));
        StringBuilder result = new StringBuilder();
        for (String number : numbers) {
            result.append(number);
        }
        return result.toString();
    }
}
