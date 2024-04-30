package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * 处理用时最长的那个任务的员工
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName HandleTouchingEmployees
 * @apiNote </br>
 * @since 2023/5/5 12:39
 */
public class HandleTouchingEmployees {
    public static int hardestWorker(int n, int[][] logs) {
        // 创建结果集合
        Set<Integer> results = new TreeSet<>();
        // 当前时间
        int currentTime = 0;
        // 最大任务时间
        int maxTime = Integer.MIN_VALUE;
        for (int[] log : logs) {
            // 判断当前任务时间是否大于最大任务时间
            int workTime = log[1] - currentTime;
            if (workTime >= maxTime) {
                // 如果集合不为空且任务时间不等于最大则清除集合
                if (!results.isEmpty() && workTime != maxTime) {
                    results.clear();
                }
                // 记录最大任务时间
                maxTime = workTime;
                // 将当前id加入集合
                results.add(log[0]);
            }
            // 更新当前时间
            currentTime = log[1];
        }
        return new ArrayList<>(results).get(0);
    }

    public static void main(String[] args) {
        int[][] results = {{0,3},{2,5},{0,9},{1,15}};
        System.out.println(hardestWorker(10, results));
    }
}
