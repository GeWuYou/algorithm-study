package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 统计一个数字在排序数组中出现的次数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName CountsNumberOfTimesNumberAppearsInSortedArray
 * @apiNote </br>
 * @since 2023/1/22 15:14
 */
public class CountsNumberOfTimesNumberAppearsInSortedArray {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int result = binaryLookup(nums, target);
        int temp;
        // 创建计数器 出现次数至少为1
        int count = 1;
        // 找到值
        if (result != -1) {
            temp = result - 1;
            // 向前查找
            while (temp >= 0) {
                if (nums[temp] == target) {
                    count++;
                } else {
                    break;
                }
                temp--;
            }
            temp = result + 1;
            // 向后查找
            while (temp < nums.length) {
                if (nums[temp] == target) {
                    count++;
                } else {
                    break;
                }
                temp++;
            }
            return count;
        }
        return 0;
    }

    /**
     * 二分法查找目标值
     *
     * @param nums   排序数组
     * @param target 目标值
     * @return int 目标值索引
     * @apiNote
     * @since 2023/1/22 15:17
     */

    public int binaryLookup(int[] nums, int target) {
        // 定义上下限
        int upper = 0;
        int lower = nums.length - 1;
        // 中点值
        int middle;
        // 进行二分查找
        while (upper <= lower) {
            // 计算中间值
            middle = (upper + lower) / 2;
            // 如果目标值大于中间值
            if (nums[middle] < target) {
                // 将上限定义在中间值前
                upper = middle + 1;
            }
            // 如果目标值小于中间值
            else if (nums[middle] > target) {
                // 将下限定义在中间值后
                lower = middle - 1;
            }
            // 如果等于则返回索引
            else {
                return middle;
            }
        }
        return -1;
    }
}

