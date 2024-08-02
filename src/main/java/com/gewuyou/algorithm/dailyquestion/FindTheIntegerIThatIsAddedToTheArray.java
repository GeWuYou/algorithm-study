package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 3131. 找出和数组相加的整数 I
 *
 * @author gewuyou
 * @since 2024-08-08 08:39:40
 */
public class FindTheIntegerIThatIsAddedToTheArray {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 计算结果
        return nums2[0]-nums1[0];
    }
}
