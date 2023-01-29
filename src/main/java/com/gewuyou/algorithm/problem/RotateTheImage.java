package com.gewuyou.algorithm.problem;

/**
 * 旋转图像
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RotateTheImage
 * @apiNote </br>
 * @since 2023/1/18 12:56
 */
public class RotateTheImage {
    public void rotate(int[][] matrix) {
        // 创建一个临时的数组指针
        int[] temporaryArray;
        // 先上下交换一维数组
        for (int i = 0; i < matrix.length / 2; i++) {
            temporaryArray = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = temporaryArray;
        }
        // 创建一个临时的数据指针
        int temporaryInt;
        // 创建一个计数器
        int count;
        // 再对角线两边交换
        for (int i = 1; i < matrix.length; i++) {
            count = 0;
            while (count < i) {
                temporaryInt = matrix[i][count];
                matrix[i][count] = matrix[count][i];
                matrix[count][i] = temporaryInt;
                count++;
            }
        }
    }
}
