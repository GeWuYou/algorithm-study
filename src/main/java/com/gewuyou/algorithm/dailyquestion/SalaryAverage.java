package com.gewuyou.algorithm.dailyquestion;

/**
 * 1491. 去掉最低工资和最高工资后的工资平均值
 *
 * @author gewuyou
 * @since 2024-05-03 下午1:51:45
 */
public class SalaryAverage {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;
        for (int i : salary) {
            sum += i;
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        sum -= max;
        sum -= min;
        sum/=(salary.length-2);
        return sum;
    }
}
