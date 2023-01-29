package com.gewuyou.algorithm.problem;

/**
 * 寻找峰值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PeakFind
 * @apiNote </br>
 * @since 2022/12/23 18:42
 */
public class PeakFind {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int findPeakElement(int[] nums) {
        // 代码健壮性检验
        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        // 定义三个指针
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        // 对数组进行二分查找
        // 当左指针大于或者等于右指针时，就表明已经找到峰值了
        while (left < right) {
            // 计算中点的值
            mid = (left + right) / 2;

            // 校验边界峰值
            if (mid == 0) {
                return mid;
            }
            if (left == mid) {
                return right;
            }

            // 先让中点値处左右值互相比较
            if (nums[mid - 1] > nums[mid + 1]) {
                // 左值更大
                if (nums[mid] > nums[mid - 1]) {
                    // 如果中点値最大，则已经找到一个峰值，直接返回
                    return mid;
                } else {
                    // 反之，移动右指针到中点位置
                    right = mid;
                }
            } else {
                // 相同或者右值更大
                if (nums[mid] > nums[mid + 1]) {
                    // 如果中点値最大，则已经找到一个峰值，直接返回
                    return mid;
                } else {
                    // 反之，移动左指针到中点位置
                    left = mid;
                }
            }
        }
        return mid;
    }
}
