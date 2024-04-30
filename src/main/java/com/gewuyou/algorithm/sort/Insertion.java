package com.gewuyou.algorithm.sort;

/**
 * 插入排序
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Insertion
 * @apiNote 稳定性：比较是从有序序列的末尾开始，也就是想要插入的元素和已经有序的最大者开始比起，如果比它大则直接插入在其后面，否则一直往前找直到找到它该插入的位置。如果碰见一个和插入元素相等的，那么把要插入的元素放在相等元素的后面。所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳定的。
 * @since 2022/9/11 12:46
 */
public class Insertion extends Sort {

    /**
     * 对数组array进行排序
     *
     * @param array 待排序数组
     * @apiNote 插入排序 从小到大排
     * @since 2022/9/11 12:47
     */
    public static void sort(Comparable[] array) {
        // 将数组分为两组 一组已排序一组未排序 执行 array.length - 1 次
        for (int i = 0; i < array.length - 1; i++) {
            // 倒序比较,先比较最大值，再向后寻找合适位置 执行 array.length - 1 次
            for (int j = i; j >= 0; j--) {
                if (greater(array[j], array[j + 1])) {
                    // 如果左值大于右值需要将其交换
                    exchange(array, j, j + 1);
                } else {
                    // 当右值大于左值时表明该位置为合适的位置，直接结束循环
                    break;
                }
            }
        }
    }
}
