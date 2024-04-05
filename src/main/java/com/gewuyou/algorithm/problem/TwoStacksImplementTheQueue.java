package com.gewuyou.algorithm.problem;

import java.util.Stack;

/**
 * 使用两个栈实现队列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TwoStacksImplementTheQueue
 * @apiNote </br>
 * @since 2023/1/7 17:21
 */
public class TwoStacksImplementTheQueue {
    /**
     * 输入栈
     */
    Stack<Integer> inputStack = new Stack<>();
    /**
     * 输出栈
     */
    Stack<Integer> outputStack = new Stack<>();

    /**
     * 入队方法
     *
     * @param node 入队元素
     * @apiNote
     * @since 2023/1/7 18:10
     */

    public void push(int node) {
        // 检查输出栈是否为空
        if (!outputStack.isEmpty()) {
            // 如果输出栈不为空，将输出栈中的数据倒回输入栈
            transfer(inputStack, outputStack);
        }
        // 将元素入栈
        inputStack.push(node);
    }

    /**
     * 出队方法
     *
     * @return int
     * @apiNote
     * @since 2023/1/7 18:11
     */

    public int pop() {
        // 检查输出栈是否为空
        if (outputStack.isEmpty() && (!inputStack.isEmpty())) {
                // 如果输出栈为空，输入栈不为空，将输入栈中的数据倒入输出栈
                transfer(outputStack, inputStack);

        }
        if(outputStack.isEmpty()){
            return -1;
        }
        return outputStack.pop();
    }

    /**
     * 栈转移方法
     *
     * @param mistress               转移者
     * @param thoseWhoAreTransferred 被转移者
     * @apiNote 将一个栈的数据倒入另一个栈中，并将前者清空
     * @since 2023/1/7 18:27
     */
    public void transfer(Stack<Integer> mistress, Stack<Integer> thoseWhoAreTransferred) {
        while (!thoseWhoAreTransferred.isEmpty()) {
            mistress.push(thoseWhoAreTransferred.pop());
        }
    }
}
