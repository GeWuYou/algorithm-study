package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 打印从 1 到最大的 n 位数
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PrintFrom1ToTheLargestNumberOfDigits
 * @apiNote </br>
 * @since 2023/3/1 12:09
 */
public class PrintFrom1ToTheLargestNumberOfDigits {
    public int[] printNumbers(int n) {
        // 计算长度
        int length = (int) Math.pow(10, n) - 1;
        // 创建结果数组
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}
