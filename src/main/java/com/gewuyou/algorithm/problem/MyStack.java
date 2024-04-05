package com.gewuyou.algorithm.problem;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 *
 * @author gewuyou
 * @since 2024-04-08 下午1:37:05
 */
public class MyStack {
    private Queue<Integer> inputQueue;
    private Queue<Integer> outputQueue;

    public MyStack() {
        inputQueue = new LinkedList<>();
        outputQueue = new LinkedList<>();
    }

    public void push(int x) {
        inputQueue.offer(x);
        while (!outputQueue.isEmpty()) {
            inputQueue.offer(outputQueue.poll());
        }
        Queue<Integer> temp = outputQueue;
        outputQueue = inputQueue;
        inputQueue = temp;
    }

    public int pop() {
        if (outputQueue.isEmpty()) {
            return -1;
        }
        return outputQueue.poll();
    }

    public int top() {
        if (outputQueue.isEmpty()) {
            return -1;
        }
        return outputQueue.peek();
    }

    public boolean empty() {
        return inputQueue.isEmpty() && outputQueue.isEmpty();
    }
}
