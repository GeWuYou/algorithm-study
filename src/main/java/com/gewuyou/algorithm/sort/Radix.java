package com.gewuyou.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * 基数排序
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Radix
 * @apiNote 基数排序是高效且稳定的排序算法
 * </br>
 * @since 2022/10/23 16:04
 */
@Slf4j
public class Radix extends Sort {

    /**
     * 对数组进行排序
     *
     * @param array 待排序数组
     * @apiNote 从小到大排序
     * @since 2022/10/23 16:32
     */
    public static void sort(int[] array) {
        // 得到数组中最大的数的位数
        int max = array[0];
        for (int k : array) {
            if (greater(k, max)) {
                max = k;
            }
        }
        // 得到最大数的是几位数 将数字转为字符串。计算字符串的长度
        int length = Integer.toString(max).length();

        /*
         第一轮排序(针对每个元素的个位进行排序处理)
         定义一个二维数组表示是10个桶,每个桶都是一维数组
         为了防止在放入数的时候，数据溢出。所以我们要让每一个桶长度为待排序数组的长度
         基数排序是经典的空间换时间的算法
         */
        int[][] bucket = new int[10][array.length];

        // 为了记录每个桶中，实际存放了多少个数据，我们定义一个一维数组来记录各个桶每次放入的数据个数
        // 可以这样理解，每个索引所对应的值为桶中放入的数据数
        int[] backetElementCounts = new int[10];
        for (int i = 0, n = 1; i < length; i++, n *= 10) {
            // 第n轮(针对每个元素的个位进行排序处理)
            for (int j : array) {

                // 取出每个元素的个位的值
                int digitOfElement = j / n % 10;
                // 放入到对应的桶中
                bucket[digitOfElement][backetElementCounts[digitOfElement]] = j;
                backetElementCounts[digitOfElement]++;
            }
            // 定义索引
            int index = 0;
            // 按照这个桶的顺序(一维数组的下标依次取出数据，放入原来的数组)
            // 遍历每一个桶，并将桶中的数据，放到原来的数组中
            for (int k = 0; k < backetElementCounts.length; k++) {
                // 如果桶中有数据。我们才放入到原数组。如果没有则跳过
                if (backetElementCounts[k] != 0) {
                    // 循环该桶
                    for (int j = 0; j < backetElementCounts[k]; j++) {
                        // 取出元素放到array中
                        array[index++] = bucket[k][j];
                    }
                    // 将桶置零
                }
                // 每一轮都需要置空桶索引
                backetElementCounts[k] = 0;
            }
            log.debug("第{}轮，对个位数进行处理 array = {}", i + 1, Arrays.toString(array));
        }
    }
}
