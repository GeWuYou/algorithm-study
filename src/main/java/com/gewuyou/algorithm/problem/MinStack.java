package com.gewuyou.algorithm.problem;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 最小栈
 *
 * @author gewuyou
 * @since 2024-05-14 下午5:17:04
 */
public class MinStack {
    private int min;
    private final Stack<Integer> stack;

    private final List<Integer> minList;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
        minList = new LinkedList<>();
    }

    public void push(int val) {
        min = Math.min(min, val);
        stack.push(val);
        if (minList.isEmpty() || val >= minList.getLast()) {
            minList.add(val);
        } else if (val <= minList.getFirst()) {
            minList.addFirst(val);
        }
    }

    public void pop() {
        int val = stack.pop();
        Iterator<Integer> iterator = minList.iterator();
        while (iterator.hasNext()) {
            if (val == iterator.next()) {
                iterator.remove();
                break;
            }
        }
        min = minList.isEmpty() ? Integer.MAX_VALUE : minList.getFirst();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin()); // -1024
        minStack.pop();
        System.out.println(minStack.getMin()); // -1024
        minStack.pop();
        System.out.println(minStack.getMin()); // 512
    }
}
