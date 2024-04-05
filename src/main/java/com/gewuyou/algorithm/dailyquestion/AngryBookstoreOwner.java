package com.gewuyou.algorithm.dailyquestion;

/**
 * 1052. 爱生气的书店老板
 *
 * @author gewuyou
 * @since 2024-04-23 下午12:28:47
 */
public class AngryBookstoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
        }
        // 创建滑动窗口
        int left = 0;
        int right = minutes - 1;
        for (int i = left; i <= right; i++) {
            if (grumpy[i] == 1) {
                sum += customers[i];
            }
        }
        int max = sum;

        // 移动滑动窗口
        while (right < n - 1) {
            right++;
            if (grumpy[left] == 1) {
                sum -= customers[left];
            }
            left++;
            if (grumpy[right] == 1) {
                sum += customers[right];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

}

