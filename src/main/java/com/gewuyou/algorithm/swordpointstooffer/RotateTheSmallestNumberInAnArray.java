package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 旋转数组中的最小数字
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RotateTheSmallestNumberInAnArray
 * @apiNote </br>
 * @since 2023/1/25 10:04
 */
public class RotateTheSmallestNumberInAnArray {
    public static int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int start = 0;
        int end = numbers.length - 1;
        int middle;
        while (start < end) {
            // 计算中间值
            middle = (start + end) / 2;
            // 终止条件
            if (start == middle) {
                return Math.min(numbers[start], numbers[end]);
            }
            // 如果中间值大于数组右界值，说明最小值在右边
            if (numbers[middle] > numbers[end]) {
                // 更新起点
                start = middle;
            }
            // 如果中间值小于数组右界值，说明最小值在左边
            else if (numbers[middle] < numbers[end]) {
                // 更新终点
                end = middle;
            }
            else {
                // 如果是等于需要逐个缩减右边界
                end--;
            }
        }
        return numbers[start];
    }
}
