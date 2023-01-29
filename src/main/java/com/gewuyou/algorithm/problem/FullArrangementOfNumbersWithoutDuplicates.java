package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 没有重复项数字的全排序列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FullArrangementOfNumbersWithoutDuplicates
 * @apiNote </br>
 * @since 2023/1/17 11:50
 */
public class FullArrangementOfNumbersWithoutDuplicates {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // 创建结果集合
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // 先将数组进行排序获取最小组合
        Arrays.sort(num);
        // 进行方法递归
        recursion(result, num, 0);
        // 返回递归后的结果集合
        return result;
    }

    /**
     * 递归方法
     *
     * @param result 结果集合
     * @param num    目标数组
     * @param index  开始索引
     * @apiNote 用于找出所有全排列
     * @since 2023/1/17 11:54
     */
    public void recursion(List<ArrayList<Integer>> result, int[] num, int index) {
        // 如果索引还未结束则继续查找
        if (index < num.length) {
            // 遍历当前组合
            for (int i = index; i < num.length; i++) {
                // 交换二者
                exchange(num, index, i);
                // 递归调用方法进行查找排列
                recursion(result, num, index + 1);
                // 回溯
                exchange(num, index, i);
            }
        }
        // 当索引到达边界时，将当前组合加入集合
        else {
            num2ArrayList(result, num);
        }
    }

    /**
     * 加入方法
     *
     * @param result
     * @param num
     * @apiNote 将组合加入结果集合
     * @since 2023/1/17 12:00
     */
    public void num2ArrayList(List<ArrayList<Integer>> result, int[] num) {
        // 创建临时集合
        ArrayList<Integer> temp = new ArrayList<>(num.length);
        // 将元素加入临时集合
        for (int element : num) {
            temp.add(element);
        }
        // 将临时集合加入结果数组中
        result.add(temp);
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
    public void exchange(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
