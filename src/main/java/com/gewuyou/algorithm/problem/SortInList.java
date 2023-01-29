package com.gewuyou.algorithm.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 链表排序
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SortInList
 * @apiNote 将链表排序并返回
 * </br>
 * @since 2022/12/20 12:35
 */
public class SortInList {
    /**
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList(ListNode head) {
        // 健壮性检验
        if (head == null || head.next == null) {
            return head;
        }

        // 准备快慢指针与临时指针
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        // 临时指针用于存储慢指针的上一节点，方便截断
        ListNode temp = head;
        // 使用快慢指针遍历无序链表，当快指针本身为null(链表长度为奇数)或者快指针下一个节点为空(链表长度为偶数)时停止遍历
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            temp = temp.next;
        }
        // 将链表截断
        temp.next = null;
        // 对前一段链表进行递归,返回已排序的链表
        ListNode list1 = sortInList(head);
        // 对后一段链表进行递归,返回已排序的链表
        ListNode list2 = sortInList(slow);
        // 调用合并方法将有序链表合并
        return merge(list1, list2);
    }

    /**
     * 将传入的两个有序链表合并
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return com.gewuyou.algorithm.problem.ListNode
     * @apiNote
     * @since 2022/12/20 14:05
     */
    public ListNode merge(ListNode list1, ListNode list2) {
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
