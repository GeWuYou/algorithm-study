package com.gewuyou.algorithm.problem;

/**
 * 876. 链表的中间结点
 *
 * @author gewuyou
 * @since 2024-05-06 下午2:24:06
 */
public class IntermediateNodeOfALinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
