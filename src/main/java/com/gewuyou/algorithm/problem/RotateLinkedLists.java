package com.gewuyou.algorithm.problem;

/**
 * 61. 旋转链表
 *
 * @author gewuyou
 * @since 2024-04-19 下午2:41:39
 */
public class RotateLinkedLists {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        // 计算链表长度
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }
        if (len == 1) {
            return head;
        }
        // 计算k的真正值
        k = k % len;
        if (k == 0) {
            return head;
        }
        p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        // 移动指针到倒数第k个节点
        for (int i = 0; i < len - k - 1; i++) {
            p = p.next;
        }
        // 断开链表
        ListNode newHead = p.next;
        p.next = null;
        // 重新连接链表
        p = newHead;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        return newHead;
    }
}
