package com.gewuyou.algorithm.problem;

/**
 * 25. K 个一组翻转链表
 *
 * @author gewuyou
 * @since 2024-07-31 下午1:35:07
 */
public class FlipLinkedListsInGroupsOfK {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // 记录起点的上一个节点
        ListNode prev = dummy;
        // 记录终点
        ListNode end = dummy;
        while (end.next != null) {
            // 移动尾指针找到要翻转的节点尾部
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 如果尾指针到达了链表尾部，则退出循环
            if (end == null) {
                break;
            }
            // 记录起点
            ListNode start = prev.next;
            // 记录终点的下一个节点
            ListNode next = end.next;
            // 断开链表
            end.next = null;
            // 反转k个节点
            prev.next = reverse(start);
            // 连接起点和反转后的链表
            start.next = next;
            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            // 记录下一个节点
            ListNode next = curr.next;
            // 让当前节点的下一个节点指向上一个节点
            curr.next = prev;
            // 移动上一个节点指针指向当前节点
            prev = curr;
            // 移动当前节点指针指向下一个节点
            curr = next;
        }
        // 返回翻转后的链表的头节点
        return prev;
    }

}
