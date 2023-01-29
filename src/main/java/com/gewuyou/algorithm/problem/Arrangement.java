package com.gewuyou.algorithm.problem;

import lombok.extern.slf4j.Slf4j;

/**
 * 排列式
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Arrangement
 * @apiNote 排列式
 * </br>7254是一个不寻常的数，因为它可以表示为7254 = 39 x 186，这个式子中1~9每个数字正好出现一次
 * </br>输出所有这样的不同的式子（乘数交换被认为是相同的式子）
 * </br>结果小的先输出；结果相同的，较小的乘数较小的先输出。
 * </br>输入描述：
 * </br>每一行输出一个式子，式子中的等号前后空格、乘号（用字母x代表）前后空格较小的乘数写在前面
 * </br>思路：
 * </br>为了满足1 ~ 9 共九位数刚好都用
 * </br>3位数 只能 =  1位数 * 3 位数 ||  2位数 * 2位数
 * </br>四位数 = 1 * 4位数 || 2 * 3 位数
 * </br>（4 +1 +4 = 9 || 4 +2 + 3 = 9）
 * </br>推下去的五位数都不能满足，不用考虑。
 * @since 2022/10/8 16:37
 */
@Slf4j
public class Arrangement {

    public static void main(String[] args) {

        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        permutation(arrays, 0);
    }

    /**
     * 全排序
     */
    private static void permutation(int[] array, int start) {
        // 当指针到达数组最大索引处时表示已经排列完成
        if (start == array.length - 1) {
            // 调用处理方法
            achieve(array);
        }
        // 从start处遍历数组
        for (int i = start; i < array.length; i++) {
            //把第一个元素分别与后面的元素进行交换，递归的调用其子数组进行排序
            swap(array, i, start);
            permutation(array, start + 1);
            //子数组排序返回后要将第一个元素交换回来。
            //如果不交换回来会出错，比如说第一次1、2交换，第一个位置为2，子数组排序返回后如果不将1、2
            //交换回来第二次交换的时候就会将2、3交换，因此必须将1、2交换使1还是在第一个位置
            swap(array, i, start);

        }
    }

    /**
     * 交换
     */
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 实现方法
     */
    private static void achieve(int[] numbers) {
        // 四位数 = 一位数 * 四位数 || 二位数 * 三位数
        // 结果
        int result;
        // 乘数
        int precede;
        // 被乘数
        int next;
        // 一位数 * 四位数
        result = numbers[0] * 1000 + numbers[1] * 100 + numbers[2] * 10 + numbers[3];
        precede = numbers[4];
        next = numbers[5] * 1000 + numbers[6] * 100 + numbers[7] * 10 + numbers[8];
        if (result == precede * next) {
            log.info("{} = {} × {}",result,precede,next);
        }
        // 二位数 * 三位数
        result = numbers[0] * 1000 + numbers[1] * 100 + numbers[2] * 10 + numbers[3];
        precede = numbers[4] * 10 + numbers[5];
        next = numbers[6] * 100 + numbers[7] * 10 + numbers[8];
        if (result == precede * next) {
            log.info("{} = {} × {}",result,precede,next);
        }
    }
}
