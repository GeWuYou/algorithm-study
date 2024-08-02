package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 3132. 找出和数组相加的整数 II
 *
 * @author gewuyou
 * @since 2024-08-08 08:58:12
 */
public class FindTheIntegerThatAddsToTheArrayII {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 记录有多少个不同的数
        int count = 0;
        // 起点
        int index = 0;
        int min = Integer.MAX_VALUE;
        while (index <= 2) {
            // 计算x
            int x = nums2[0] - nums1[index];
            int index2 = 1;
            for (int i = index + 1; i < n1 && index2 < n2; i++) {
                // 如果count超过3或者小于2则结束本轮
                if (count >= 3) {
                    break;
                }
                if (nums1[i] + x != nums2[index2]) {
                    count++;
                } else {
                    index2++;
                }
            }
            index++;
            // 计算最小值 如果count小于3且index2等于n2则说明可以找到最小值
            if (count < 3 && index2 == n2) {
                min = Math.min(min, x);
            }
            count = 0;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums1 = {7, 2, 6, 8, 7};
        int[] nums2 = {7, 6, 5};
        FindTheIntegerThatAddsToTheArrayII solution = new FindTheIntegerThatAddsToTheArrayII();
        System.out.println(solution.minimumAddedInteger(nums1, nums2));
    }

}
