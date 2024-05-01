package com.gewuyou.algorithm.problem;

/**
 * 941. 有效的山脉数组
 *
 * @author gewuyou
 * @since 2024-05-10 下午1:28:16
 */
public class ValidArrayOfMountains {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) {
            return false;
        }
        int left = 0;
        int right = n - 1;
        // 找到山峰
        // 找到山峰
        while (left < n - 1 && arr[left] < arr[left + 1]) {
            left++;
        }
        // 找到山峰
        while (right > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        if (left == right && left != 0 && right != n - 1) {
            return true;
        }
        return false;
    }
}
