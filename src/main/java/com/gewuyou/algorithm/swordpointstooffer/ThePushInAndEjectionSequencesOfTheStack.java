package com.gewuyou.algorithm.swordpointstooffer;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ThePushInAndEjectionSequencesOfTheStack
 * @apiNote </br>
 * @since 2023/2/18 20:59
 */
public class ThePushInAndEjectionSequencesOfTheStack {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 创建一个辅助栈
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int j : pushed) {
            // 如果当前入栈元素与出栈元素不同则加入栈中
            if (j != popped[index]) {
                stack.push(j);
            }
            // 如果相同则不加入栈中
            else {
                index++;
                // 判断是否存在继续出栈的情况
                while (!stack.isEmpty() && stack.peek() == popped[index]) {
                    index++;
                    stack.pop();
                }
            }
        }
        // 弹出栈中元素与数组进行比较
        for (int i = index; i < popped.length; i++) {
            if (stack.pop() != popped[i]) {
                return false;
            }
        }
        return true;
    }
}
