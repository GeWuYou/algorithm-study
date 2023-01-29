package com.gewuyou.algorithm.problem;

/**
 * 二维数组中查找目标值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FindTargetBy2Array
 * @apiNote </br>
 * @since 2022/12/22 13:14
 */
public class FindTargetBy2Array {
    /**
     * 暴力解法
     *
     * @param target 目标值
     * @param array  二维数组
     * @return boolean 结果
     * @apiNote
     * @since 2022/12/22 13:27
     */
    public boolean Find1(int target, int[][] array) {
        // 代码健壮性检验
        if (array == null || array[0].length == 0) {
            return false;
        }
        for (int[] ints : array) {
            if (ints[0] > target) {
                return false;
            }
            for (int anInt : ints) {
                if (anInt == target) {
                    return true;
                }
                if (anInt > target) {
                    break;
                }
            }
        }
        return false;
    }

    /**
     * 线性搜索
     *
     * @param target 目标值
     * @param array  二维数组
     * @return boolean 结果
     * @apiNote
     * @since 2022/12/22 13:54
     */
    public boolean Find(int target, int[][] array) {
        // 代码健壮性检验
        if (array == null || array[0].length == 0) {
            return false;
        }
        // 设置搜索起点，默认为0
        int start = 0;
        for (int length = array.length; length > 0; length--) {
            // 如果首元素就大于目标值，则没有继续的必要
            if (array[length - 1][0] > target) {
                continue;
            }
            for (int i = start; i < array[0].length; i++) {
                if (array[length - 1][i] == target) {
                    return true;
                }
                // 当遇到第一个大于目标值的节点时，记录位置，并设置为下一次循环的起点
                if (array[length - 1][i] > target) {
                    start = i;
                    break;
                }
            }
        }
        return false;
    }
}
