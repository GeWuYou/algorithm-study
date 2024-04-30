package com.gewuyou.algorithm.problem;

/**
 * 有序链表的合并
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName LinkedListMerge
 * @apiNote </br>
 * @since 2022/11/17 16:35
 */
public class LinkedListMerge {
    public ListNode Merge(ListNode list1, ListNode list2) {
        // 设list1为主链表 创建两个指针
        ListNode flag = new ListNode(0);
        ListNode head = flag;
        while (list1 != null && list2 != null) {
            // 比较两个指针值
            if (list1.val > list2.val) {
                flag.next = list2;
                list2 = list2.next;
            } else if (list1.val < list2.val) {
                flag.next = list1;
                list1 = list1.next;
            } else {
                flag.next = list1;
                list1 = list1.next;
                flag = flag.next;
                flag.next = list2;
                list2 = list2.next;
            }
            flag = flag.next;
        }
        // 判断是否还有链表未遍历完
        if (list1 != null) {
            flag.next = list1;
        }
        if (list2 != null) {
            flag.next = list2;
        }
        return head.next;
    }

}
