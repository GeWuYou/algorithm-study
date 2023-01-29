package com.gewuyou.algorithm.sort;

/**
 * 排序类
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Sort
 * @apiNote 作为所有排序的父类
 * @since 2022/9/11 14:39
 */
public class Sort {



    /**
     * 比较v与w大小
     *
     * @param v 比较者
     * @param w 被比较者
     * @return boolean
     * @apiNote 如果v大于w返回true反之返回false
     * @since 2022/9/11 13:57
     */
    public static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    /**
     * 交换array数组中索引i处与索引j处的值
     *
     * @param array 数组
     * @param i     索引
     * @param j     索引
     * @apiNote
     * @since 2022/9/11 13:57
     */
    public static void exchange(Comparable[] array, int i, int j) {
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
