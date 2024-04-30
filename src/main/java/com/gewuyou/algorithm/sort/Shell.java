package com.gewuyou.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

/**
 * 希尔排序
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Shell
 * @apiNote 稳定性：希尔排序是按照不同步长对元素进行插入排序 ,虽然一次插入排序是稳定的，不会改变相同元素的相对顺序，但在不同的插入排序过程中，相同的元素可能在各自的插入排序中移动，最后其稳定性就会被打乱，所以希尔排序是不稳定的。
 * @since 2022/9/11 13:55
 */
@Slf4j
public class Shell extends Sort {

    /**
     * 对数组array进行排序
     *
     * @param array 待排序数组
     * @apiNote 希尔排序 从小到大排 交换法
     * @since 2022/9/11 13:56
     */
    public static void sort(Comparable[] array) {
        // 声明步长为1
        int h = 1;
        // 根据数组长度对步长进行初始化
        while (h < array.length) {
            h = 2 * h + 1;
        }
        // 希尔排序
        while (h >= 1) {
            // 进行排序
            // 1、找到待插入的元素
            // ? 为什么起始点为h？因为第一个待插入元素索引恰好为步长
            for (int i = h; i < array.length; i++) {
                // 2、把待插入的元素插入到有序数列中
                for (int j = i; j >= h; j -= h) {
                    // 待插入的元素是array[j],比较array[j]与array[j-h]的大小
                    if (greater(array[j - h], array[j])) {
                        // 如果右值大于左值，交换二者位置
                        exchange(array, j, j - h);
                    } else {
                        // 该元素已经处于合适的位置了，结束当前循环
                        break;
                    }
                }
            }
            // 减小h的值
            h /= 2;
        }
    }
}
