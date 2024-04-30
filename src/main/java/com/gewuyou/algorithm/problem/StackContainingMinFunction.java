package com.gewuyou.algorithm.problem;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName StackContainingMinFunction
 * @apiNote </br>
 * @since 2023/1/7 18:54
 */
public class StackContainingMinFunction {
    /**
     * 最小值栈
     */
    Stack<Integer> minimumStack = new Stack<>();
    /**
     * 主栈
     */
    Stack<Integer> mainStack = new Stack<>();

    /**
     * 普普通通push方法
     *
     * @param node 元素
     * @apiNote 将value压入栈中
     * @since 2023/1/7 19:06
     */
    public void push(int node) {
        // 判断最小值栈是否为空
        if (mainStack.isEmpty()) {
            minimumStack.push(node);
        } else {
            // 如果最小值栈中栈顶元素大于输入元素，将该元素加入最小值栈中
            if (minimumStack.peek() >= node) {
                minimumStack.push(node);
            }
        }
        mainStack.push(node);
    }

    /**
     * 普普通通pop方法
     *
     * @apiNote 弹出栈顶元素
     * @since 2023/1/7 19:12
     */

    public void pop() {
        // 判断主栈是否为空，为空不执行方法
        if (mainStack.isEmpty()) {
            return;
        }
        // 判断出栈元素是否为当前最小值，如果是则在主栈弹出元素的同时最小值栈也弹出元素
        if (mainStack.pop().equals(minimumStack.peek())) {
            minimumStack.pop();
        }
    }

    /**
     * 普普通通top方法
     *
     * @return int
     * @apiNote 获取栈顶元素
     * @since 2023/1/7 19:15
     */
    public int top() {
        return mainStack.peek();
    }

    /**
     * 普普通通min方法
     *
     * @return int
     * @apiNote 获取栈中最小元素
     * @since 2023/1/7 19:16
     */
    public int min() {
        return minimumStack.peek();
    }
}
