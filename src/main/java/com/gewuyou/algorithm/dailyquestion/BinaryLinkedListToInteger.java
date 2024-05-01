package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.problem.ListNode;

/**
 * 1290. 二进制链表转整数
 *
 * @author gewuyou
 * @since 2024-05-22 上午11:56:21
 */
public class BinaryLinkedListToInteger {
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
