package com.gewuyou.algorithm.sort;


import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Bubble
 * @apiNote 稳定性：只有当array[i]>array[i+1]时。才会交换元素位置，而相等是时候并不会交换位置，所以冒泡排序是一种稳定的排序算法
 * @since 2022/9/11 10:51
 */
@Slf4j
public class Bubble extends Sort {

    /**
     * 对数组array进行排序
     *
     * @param array 待排序数组
     * @apiNote 冒泡排序 从小到大排
     * @since 2022/9/11 10:57
     */
    public static void sort(Comparable[] array) {
        // 优化冒泡算法 标识变量，表示是否进行过交换
        boolean flag = false;
        // 进行array.length-1次冒泡 比如长度为6，进行5次冒泡，因为第6次排序时，只剩最后一个元素了，无需进行比较
        for (int i = 0; i < array.length - 1; i++) {
            // 单次冒泡进行array.length-i-1次比较， 比如长度为6,第1次冒泡进行6-0-1=5次比较找出第一个最大值
            for (int j = 0; j < array.length - i - 1; j++) {

                if (greater(array[j], array[j + 1])) {
                    // 如果排序过,设置为true
                    flag = true;
                    exchange(array, j, j + 1);
                }
            }
            log.info("交换第{}次的数组：{}", i + 1, Arrays.toString(array));
            // 在一趟排序中一次交换都没有发生
            if (!flag) {
                break;
            } else {
                // 重置flag。进行下次判断
                flag = false;
            }
        }
    }
}
