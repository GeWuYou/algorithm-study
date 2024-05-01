package com.gewuyou.algorithm.problem;

/**
 * 147. 对链表进行插入排序
 *
 * @author gewuyou
 * @since 2024-05-11 下午1:16:39
 */
public class SortTheInsertsOfTheLinkedList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode lastSorted = head,cur = head.next;
        while (cur != null) {
            // 无需插入，直接移动指针
            if(lastSorted.val<=cur.val){
                lastSorted = lastSorted.next;
            }
            // 插入
            else {
                ListNode prev = dummy;
                while (prev.next.val<=cur.val){
                    prev = prev.next;
                }
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummy.next;
    }
}
