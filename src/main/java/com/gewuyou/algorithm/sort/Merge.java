package com.gewuyou.algorithm.sort;

/**
 * 归并排序
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Merge
 * @apiNote 稳定性：归并排序在归并的过程中，只有arr[i]<arr[i+1]的时候才会交换位置，如果两个元素相等则不会交换位置，所以它并不会破坏稳定性，归并排序是稳定的。
 * @since 2022/9/11 14:45
 */
public class Merge extends Sort {

    /**
     * 完成归并操作所需要的辅助数组
     */
    private static Comparable[] assistance;

    /**
     * 对数组array进行排序
     *
     * @param array 待排序数组
     * @apiNote 归并排序 从小到大排
     * @since 2022/9/11 14:49
     */
    public static void sort(Comparable[] array) {
        // 1、初始化辅助数组assistance
        assistance = new Comparable[array.length];
        // 2、定义一个start变量,和一个end变量，分别记录数组中最小的索引和最大的索引
        int start = 0;
        int end = array.length - 1;
        // 3、调用sort的重载方法完成数组array中。从索引start到索引end的元素的排序
        sort(array, start, end);
    }

    /**
     * 对数组array中从索引o1处到索引o2之间的元素进行排序
     *
     * @param array 待排序数组
     * @param start 索引1
     * @param end   索引2
     * @apiNote 归并排序 从小到大排
     * @since 2022/9/11 14:50
     */
    public static void sort(Comparable[] array, int start, int end) {
        // 1、安全性校验
        if (end <= start) {
            return;
        }
        // 2、对start到end之间的数据进行分组
        // 定义一个中间元素middle进行数据存储
        int middle = (end + start) / 2;
        // 3、分别对每一组数据进行递归排序
        sort(array, start, middle);
        sort(array, middle + 1, end);
        // 4、分别把两个组之间的数据进行归并
        merge(array, start, middle, end);
    }

    /**
     * 有序合并数组array中由索引start至middle的数组与索引middle至索引end的数组
     *
     * @param array  主数组
     * @param start  开始索引
     * @param middle 中间索引
     * @param end    尾部索引
     * @apiNote 索引start到索引middle为一个数组，索引middle到索引end为另一个数组。把数组array中的这两个子数组合并成一个有序的数组
     * @since 2022/9/11 14:57
     */
    private static void merge(Comparable[] array, int start, int middle, int end) {
        // 1、定义3个指针
        int p = start;
        int p1 = start;
        int p2 = middle + 1;
        // 2、遍历。移动p1指针和p2指针。比较对应索引处的值，找出小的那个放到辅助数组，放到数组的对应索引处
        while (p1 <= middle && p2 <= end) {
            // 比较对应索引处的值
            if (!greater(array[p1], array[p2])) {
                // 如果p1索引处的值小于p2索引处的值，将p1处的值加入到辅助数组中
                assistance[p++] = array[p1++];
            } else {
                // 反之p2索引处值小则将p2处的值加入到辅助数组中
                assistance[p++] = array[p2++];
            }
        }
        // 3、遍历，如果p1指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组的对应索引处
        while (p1 <= middle) {
            assistance[p++] = array[p1++];
        }
        // 4、遍历，如果p2指针没有走完，那么顺序移动p2指针，把对应的元素放到辅助数组的对应索引处
        while (p2 <= end) {
            assistance[p++] = array[p2++];
        }
        // 5、将辅助数组中的元素拷贝到原数组中
        if (end + 1 - start >= 0) {
            System.arraycopy(assistance, start, array, start, end + 1 - start);
        }

    }
}
