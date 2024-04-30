package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.swordpointstooffer.ListNode;

/**
 * 环形链表②
 *
 * @author GeWuYou
 * @version V1.0.0
 * @apiNote </br>
 * @since 2023/7/30 9:44
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != fast) {
            if (slow == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
