package com.gewuyou.algorithm.dailyquestion;

/**
 * 3011. 判断一个数组是否可以变为有序
 *
 * @author gewuyou
 * @since 2024-07-13 下午2:51:08
 */
public class DeterminesWhetherAnArrayCanBeOrdered {
    public boolean canSortArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                    if (!check(nums[i], nums[j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean check(int i,int j){
        var iCount = Integer.bitCount(i);
        var jCount = Integer.bitCount(j);
        return iCount == jCount;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
