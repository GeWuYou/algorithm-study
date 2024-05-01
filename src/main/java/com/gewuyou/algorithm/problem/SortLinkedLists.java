package com.gewuyou.algorithm.problem;

/**
 * 148. 排序链表
 *
 * @author gewuyou
 * @since 2024-05-11 下午1:58:12
 */
public class SortLinkedLists {
    public ListNode sortList(ListNode head) {
       return new SortTheInsertsOfTheLinkedList().insertionSortList(head);
    }
}
