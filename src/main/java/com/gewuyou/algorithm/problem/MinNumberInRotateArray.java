package com.gewuyou.algorithm.problem;

/**
 * 旋转数组的最小数字
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MinNumberInRotateArray
 * @apiNote </br>
 * @since 2022/12/26 14:54
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        // 定义双指针分别指向旋转数组的首尾
        int start = 0;
        int end = array.length - 1;
        return array[minNumberInRotateArray(array, start, end)];
    }

    public int minNumberInRotateArray(int[] array, int start, int end) {
        if (array.length == 1) {
            return array[0];
        }
        // 中点索引
        int mid = (start + end) / 2;
        // 终止条件
        if (start == mid) {
            return array[start] > array[end] ? end : start;
        }
        // 如果中点値大于右边界值，说明最小值仍在中点右边
        if (array[mid] > array[end]) {
            // 变换左边界值
            start = mid;
            return minNumberInRotateArray(array, start, end);

            // 如果中点値小于右边界值，说明最小值在中点左边
        } else if (array[mid] < array[end]) {
            // 变换右边界值
            end = mid;
            return minNumberInRotateArray(array, start, end);
            // 如果中点値等于右边界值，不容易区分区间，应当逐步减小右边区间
        } else {
            // 变换右边界值
            end--;
            return minNumberInRotateArray(array, start, end);
        }
    }

}
