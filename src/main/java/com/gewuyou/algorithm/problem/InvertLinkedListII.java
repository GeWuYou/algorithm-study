package com.gewuyou.algorithm.problem;

/**
 * 92. 反转链表 II
 *
 * @author gewuyou
 * @since 2024-04-27 下午2:41:03
 */
public class InvertLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        // 创建虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        // 移动指针到左边界
        for (int i = 0; i < left - 1; i++) {
            prev = curr;
            curr = curr.next;
        }
        // 反转链表
        ListNode prevNode = null;
        ListNode nextNode;
        for (int i = 0; i < right - left + 1; i++) {
            // 记录下一个节点
            nextNode = curr.next;
            // 反转当前节点的指针
            curr.next = prevNode;
            prevNode = curr;
            // 移动指针到下一个节点
            curr = nextNode;
        }
        // 连接反转链表
        prev.next.next = curr;
        prev.next = prevNode;
        return dummy.next;
    }
}
