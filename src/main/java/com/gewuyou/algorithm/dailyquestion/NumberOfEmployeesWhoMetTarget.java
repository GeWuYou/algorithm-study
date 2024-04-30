package com.gewuyou.algorithm.dailyquestion;

/**
 * 2798. 满足目标工作时长的员工数目
 *
 * @author gewuyou
 * @since 2024-04-30 上午8:07:47
 */
public class NumberOfEmployeesWhoMetTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int hour : hours) {
            if (hour >= target) {
                count++;
            }
        }return count;
    }
}
