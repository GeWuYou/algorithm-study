package com.gewuyou.algorithm.dailyquestion;

import java.util.Arrays;

/**
 * 使数组连续的最少操作数
 *
 * @author gewuyou
 * @since 2024-04-08 上午9:35:16
 */
public class MinOperations {
    public int minOperations(int[] nums) {
        // 对数组进行排序
        Arrays.sort(nums);
        // 获取数组的长度
        int n = nums.length;
        // 去除排序后数组中的重复元素，并获取去重后的长度
        int m = removeDuplicates(nums);
        // 初始化左右两个指针为0
        int l = 0, r = 0;
        // 遍历去重后的数组
        while (r < m) {
            // 如果右指针与左指针之间的距离大于等于数组长度
            if (nums[r++] - nums[l] >= n) {
                // 将左指针右移
                l++;
            }
        }
        // 返回非递减数组所需的最小操作次数
        return n - (r - l);
    }

    private int removeDuplicates(int[] nums) {
        int n = nums.length;  // 数组的长度
        int i = 0, j = 1;  // 两个指针i和j，分别标记不重复元素的最后下标和遍历数组的下标
        while (j < n) {  // 遍历整个数组
            if (nums[i] != nums[j]) {  // 如果当前元素与前一个元素不相同
                nums[++i] = nums[j];  // 将当前元素放到不重复元素的末尾
            }
            j++;  // 继续遍历下一个元素
        }
        return i + 1;  // 返回不重复元素的个数，即新数组的长度
    }

}
