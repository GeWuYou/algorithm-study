package com.gewuyou.algorithm.swordpointstooffer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaximumValueOfTheQueue
 * @apiNote </br>
 * @since 2023/2/25 12:25
 */
public class MaximumValueOfTheQueue {
    /**
     * 主队列
     */
    Queue<Integer> queue;
    /**
     * 辅助队列
     */
    Deque<Integer> deque;

    public MaximumValueOfTheQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        // 判空
        if (!deque.isEmpty()) {
            return deque.peekFirst();
        }
        return -1;
    }

    public void push_back(int value) {
        // 入队
        queue.offer(value);
        // 删除辅助队列中比该元素小的值
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.removeLast();
        }
        // 将该值加入辅助队列中
        deque.addLast(value);
    }

    public int pop_front() {
        // 判空
        if (queue.isEmpty()) {
            return -1;
        }
        // 判断出队的是否为队列最大值
        if (!deque.isEmpty() && deque.peekFirst().equals(queue.peek())) {
            // 出队
            deque.removeFirst();
        }
        return queue.poll();
    }
}
