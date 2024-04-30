package com.gewuyou.algorithm.swordpointstooffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口的最大值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaximumValueOfTheSlidingWindow
 * @apiNote </br>
 * @since 2023/2/25 11:55
 */
public class MaximumValueOfTheSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        // 判空
        if (length == 0 || k == 0) {
            return new int[0];
        }
        // 创建结果数组
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        // 未形成窗口
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        assert deque.peekFirst() != null;
        res[0] = deque.peekFirst();
        // 形成窗口后
        for (int i = k; i < length; i++) {
            // 判断移动窗口后出去的是否为队列中最大的元素,如果是则从队列中出队
            if (!deque.isEmpty() && deque.peekFirst() == nums[i - k]) {
                deque.removeFirst();
            }
            // 判断移动窗口后加入的元素在队列中所在的位置，将其放在队列中合适的位置
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            // 将当前窗口的最大值加入结果数组
            if (!deque.isEmpty()) {
                res[i - k + 1] = deque.peekFirst();
            }
        }
        return res;
    }
}
