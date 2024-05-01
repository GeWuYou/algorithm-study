package com.gewuyou.algorithm.dailyquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 826. 安排工作以达到最大收益
 *
 * @author gewuyou
 * @since 2024-05-17 下午2:06:03
 */
public class ScheduleWorkToMaximizeBenefits {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int profitSum = 0;
        // 创建一个包含难度和利润的工作列表
        List<int[]> jobs = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            jobs.add(new int[]{difficulty[i], profit[i]});
        }
        // 按难度对作业进行排序，如果作业具有相同的难度，则按利润降序排序
        jobs.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        // 对工作数组进行排序
        Arrays.sort(worker);
        int jobsIndex = 0;
        int maxProfit = 0;
        // 遍历每个工作人员并分配他们能做的最佳工作
        for (int waddle : worker) {
            while (jobsIndex < jobs.size() && jobs.get(jobsIndex)[0] <= waddle) {
                maxProfit = Math.max(maxProfit, jobs.get(jobsIndex)[1]);
                jobsIndex++;
            }
            profitSum += maxProfit;
        }
        return profitSum;
    }


    public static void main(String[] args) {
        int[] difficulty = {2, 17, 19, 20, 24, 29, 33, 43, 50, 51, 57, 67, 70, 72, 73, 75, 80, 82, 87, 90};
        int[] profit = {6, 7, 10, 17, 18, 29, 30, 31, 34, 39, 40, 42, 48, 54, 57, 78, 78, 78, 83, 88};
        int[] worker = {12, 9, 11, 41, 11, 87, 48, 6, 48, 93, 76, 73, 7, 50, 55, 97, 47, 33, 46, 10};
        ScheduleWorkToMaximizeBenefits solution = new ScheduleWorkToMaximizeBenefits();
        int result = solution.maxProfitAssignment(difficulty, profit, worker);
        System.out.println(result);
    }
}
