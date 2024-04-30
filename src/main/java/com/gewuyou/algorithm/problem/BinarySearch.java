package com.gewuyou.algorithm.problem;

/**
 * 二分查找
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BinarySearch
 * @apiNote </br>
 * @since 2022/12/22 11:10
 */
public class BinarySearch {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        // 代码健壮性检验
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 定义上下限制与中间值
        int upper = 0;
        int lower = nums.length - 1;
        // 中点
        int mid;
        while (upper <= lower) {
            // 计算中点的值
            mid = (upper + lower) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                lower = mid - 1;
            } else {
                upper = mid + 1;
            }
        }
        return -1;
    }
}
