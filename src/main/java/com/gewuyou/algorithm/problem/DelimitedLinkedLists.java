package com.gewuyou.algorithm.problem;

/**
 * 86. 分隔链表
 *
 * @author gewuyou
 * @since 2024-04-25 下午3:04:02
 */
public class DelimitedLinkedLists {
    public ListNode partition(ListNode head, int x) {
        ListNode minSentinel = new ListNode(-999);
        ListNode pMin = minSentinel;

        ListNode maxSentinel = new ListNode(-999);
        ListNode pMax = maxSentinel;


        while (head!= null) {
            if (head.val < x) {
                pMin.next = head;
                pMin = pMin.next;
            } else {
                pMax.next = head;
                pMax = pMax.next;
            }
            head = head.next;
        }
        pMin.next = maxSentinel.next;
        pMax.next = null;
        return minSentinel.next;
    }
}
