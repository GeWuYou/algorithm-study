package com.gewuyou.algorithm.problem;

import java.util.LinkedList;
import java.util.Queue;

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
        if (list1 == null && list2 == null) {
            return null;
        }
        /*
          思路：
          使用两个队列存储该链表，通过比较两个出队的数据来创建合并后的有序链表
         */
        // 创建两个队列
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        // 将链表的数据倒入
        while (list1 != null) {
            queue1.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            queue2.add(list2.val);
            list2 = list2.next;
        }
        // 创建一个新头节点
        ListNode head = new ListNode(-1);
        ListNode flagNode = head;

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            if (queue1.peek() < queue2.peek()) {
                flagNode.next = new ListNode(queue1.poll());
            } else {
                flagNode.next = new ListNode(queue2.poll());
            }
            flagNode = flagNode.next;
        }
        // 如果其中一个队列已经空了，则直接将另一个的值全部放入新链表
        while (!queue1.isEmpty()) {
            flagNode.next = new ListNode(queue1.poll());
            flagNode = flagNode.next;
        }
        while (!queue2.isEmpty()) {
            flagNode.next = new ListNode(queue2.poll());
            flagNode = flagNode.next;
        }
        // 返回链表
        return head.next;
    }

}
