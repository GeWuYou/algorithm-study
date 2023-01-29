package com.gewuyou.algorithm.problem;

/**
 * 寻找两个正序数组的中位数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FindMedianSortedArrays
 * @apiNote </br>
 * @since 2023/3/12 9:02
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 计算两个数组长度
        int n = nums1.length;
        int m = nums2.length;
        // 合并后数组的长度
        int length = n + m;
        // 由于偶数需要中间数与上一个数，所以创建两个变量标记
        int left = -1;
        int right = -1;
        // 创建指针记录在两个数组的位置
        int aStart = 0;
        int bStart = 0;
        for (int i = 0; i <= length / 2; i++) {
            // 记录此时的数
            left = right;
            // 如果a处索引小于该数组长度且此时对应处的值小于b处对应的值或者b已遍历完则移动a索引
            if (aStart < n && (bStart >= m||nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        // 判断这个合并后的数组长度是奇数还是偶数
        if ((length & 1) == 1) {
            return right;
        } else {
            return (left + right) / 2.0;
        }

    }
}
