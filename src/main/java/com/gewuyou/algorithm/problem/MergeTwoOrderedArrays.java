package com.gewuyou.algorithm.problem;

/**
 * 合并两个有序数组
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MergeTwoOrderedArrays
 * @apiNote </br>
 * @since 2023/4/14 10:22
 */
public class MergeTwoOrderedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] sorted = new int[m + n];
        int curr;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                curr = nums2[p2++];
            } else if (p2 == n) {
                curr = nums1[p1++];
            } else if (nums1[p1] <= nums2[p2]) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }
            sorted[p1 + p2 - 1] = curr;
        }
        if (m + n >= 0) {
            System.arraycopy(sorted, 0, nums1, 0, m + n);
        }
    }
}
