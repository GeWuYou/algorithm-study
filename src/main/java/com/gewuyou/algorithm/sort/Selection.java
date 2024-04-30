package com.gewuyou.algorithm.sort;

/**
 * 选择排序
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Selection
 * @apiNote 稳定性：选择排序是给每个位置选择当前元素最小的,例如有数据{5(1)，8 ，5(2)， 2， 9 },第一遍选择到的最小元素为2，所以5(1)会和2进行交换位置，此时5(1)到了5(2)后面，破坏了稳定性，所以选择排序是一种不稳定的排序算法。
 * @since 2022/9/11 12:10
 */
public class Selection extends Sort {
    /**
     * 对数组array进行排序
     *
     * @param array 待排序数组
     * @apiNote 选择排序 从小到大排
     * @since 2022/9/11 10:57
     */
    public static void sort(Comparable[] array) {
        // 声明最小值索引
        int minIndex;
        // ? 为什么减一？ 当进行第array.length-1次排序时待排序的元素只剩下一个元素了，只有当待排序的元素大于等于2时才有排序的意义
        for (int i = 0; i < array.length - 1; i++) {
            // 设置默认最小值索引为i
            minIndex = i;
            // 排序起点应从最小索引+1处开始
            for (int j = i + 1; j < array.length; j++) {
                // 比较最小值 如果最小值大于当前值 取当前索引为最小值
                if (greater(array[minIndex], array[j])) {
                    minIndex = j;
                }
            }
            // 将最小值放到最前面
            exchange(array, minIndex, i);
        }
    }
}
