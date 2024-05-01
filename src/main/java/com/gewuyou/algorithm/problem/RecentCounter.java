package com.gewuyou.algorithm.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. 最近的请求次数
 *
 * @author gewuyou
 * @since 2024-05-09 下午3:19:46
 */
public class RecentCounter {
    private final Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        // 将不在 [t-3000, t] 时间范围内的时间点出队
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        // 将当前时间加入队列
        queue.offer(t);
        // 返回队列的大小
        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}
