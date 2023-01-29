package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.problem.ListNode;

/**
 * 合并两个链表
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MergeTwoLinkedLists
 * @apiNote </br>
 * @since 2023/1/30 12:31
 */
public class MergeTwoLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int start, int end, ListNode list2) {
        ListNode head = list1;
        for (int i = 0; i < start; i++) {
            head = head.next;
        }
        ListNode tail = head;
        for (int i = 0; i < end - start + 2; i++) {
            tail = tail.next;
        }
        head.next = list2;
        while (head.next != null) {
            head = head.next;
        }
        head.next = tail;
        return list1;
    }
}
