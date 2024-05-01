package com.gewuyou.algorithm.dailyquestion;

import java.util.HashMap;
import java.util.Map;

/**
 * 2244. 完成所有任务需要的最少轮数
 *
 * @author gewuyou
 * @since 2024-05-14 上午9:11:07
 */
public class MinimumNumberOfRoundsRequiredForTheTask {
    public int minimumRounds(int[] tasks) {
        int totalRounds = 0;
        Map<Integer, Integer> taskCounts = new HashMap<>();

        // 统计每种难度级别的任务数目
        for (int task : tasks) {
            taskCounts.put(task, taskCounts.getOrDefault(task, 0) + 1);
        }
        for (Integer count : taskCounts.values()) {
            // 如果任务数量为1则无法完成
            if (count == 1) {
                return -1;
            }
            // 如果任务数为2或3，则需要1轮
            if (count == 2 || count == 3) {
                totalRounds++;
            } else {
                // 计算需要多少轮，其中包括尽可能多的3个任务的轮数
                int roundOF3 = count / 3;
                int remainder = count % 3;
                // 余数为0,则直接加上3的轮数
                if (remainder == 0) {
                    totalRounds += roundOF3;
                } else
                // 余数为1说明需要减少3的轮数中的一轮，增加两轮2的轮数
                // 余数为2说明需要增加一轮3的轮数，这两种情况都只是增加一轮即可
                {
                    totalRounds += roundOF3 + 1;
                }
            }
        }
        return totalRounds;
    }

    public static void main(String[] args) {
        MinimumNumberOfRoundsRequiredForTheTask solution = new MinimumNumberOfRoundsRequiredForTheTask();
        int[] tasks = {2, 2, 3, 3, 2, 4, 4, 4, 4, 4};
        int result = solution.minimumRounds(tasks);
        System.out.println(result);
    }
}
