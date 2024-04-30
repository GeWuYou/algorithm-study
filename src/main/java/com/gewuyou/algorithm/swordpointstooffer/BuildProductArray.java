package com.gewuyou.algorithm.swordpointstooffer;

import java.util.Arrays;

/**
 * 构建乘积数组
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BuildProductArray
 * @apiNote </br>
 * @since 2023/2/14 11:01
 */
public class BuildProductArray {
    public int[] constructArr(int[] array) {
        int length = array.length;
        // 构建辅助数组
        int[] assist = new int[length];
        // 初始化辅助数组
        Arrays.fill(assist, 1);
        // 初始化辅助变量
        int temp = 1;
        // 计算下三角
        for (int i = 1; i < length; i++) {
            assist[i] = assist[i - 1] * array[i - 1];
        }
        // 计算下三角
        for (int i = length - 2; i >= 0; i--) {
           temp*=array[i+1];
           assist[i]*=temp;
        }
        return assist;
    }
}
