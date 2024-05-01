package com.gewuyou.algorithm.dailyquestion;

/**
 * 1953. 你可以工作的最大周数
 *
 * @author gewuyou
 * @since 2024-05-16 下午2:04:08
 */
public class MaximumNumberOfWeeksYouCanWork {
    public long numberOfWeeks(int[] milestones) {
        long totalTasks = 0;
        long maxTasks = 0;
        // 计算所有任务的总数和最大任务数
        for (int milestone : milestones) {
            totalTasks += milestone;
            maxTasks = Math.max(maxTasks, milestone);
        }
        long otherTasks = totalTasks - maxTasks;
        // 如果最大任务数超过其它任务总和+1则只能完成到无法继续
        if (maxTasks > otherTasks + 1) {
            return 2L * otherTasks + 1L;
        }

        // 否则可以完成到最大任务数
        return totalTasks;
    }

    public static void main(String[] args) {

        MaximumNumberOfWeeksYouCanWork solution = new MaximumNumberOfWeeksYouCanWork();
        int[] milestones = {1, 2, 3, 7, 3, 6, 8, 3, 2, 6, 78, 99};
        long result = solution.numberOfWeeks(milestones);
        System.out.println(result);
    }
}
