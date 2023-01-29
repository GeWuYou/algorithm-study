package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 合并K个已排序的链表
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MergeKLists
 * @apiNote </br>
 * @since 2022/12/2 15:57
 */
public class MergeLists {

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        List<ListNode> listNodes = mergeByLists(lists);
        if (listNodes.isEmpty()) {
            return null;
        } else {
            return listNodes.get(0);
        }
    }

    public List<ListNode> mergeByLists(ArrayList<ListNode> lists) {
        if (lists.isEmpty()) {
            return lists;
        }
        // 判断链表集合中链表元素数量
        int listSize = lists.size();
        if (listSize == 1) {
            return lists;
        }
        // 创建一个新集合接收合并后的链表
        ArrayList<ListNode> temp = new ArrayList<>();
        // 如果是偶数
        if (listSize % 2 == 0) {
            for (int i = 0; i < listSize; i += 2) {
                // 将合并后的链表加入到临时集合
                temp.add(mergeBy2(lists.get(i), lists.get(i + 1)));
            }
        } else {
            //如果是奇数
            for (int i = 0; i < listSize; i += 2) {
                if (i == listSize - 1) {
                    temp.add(lists.get(i));
                    break;
                }
                // 将合并后的链表加入到临时集合
                temp.add(mergeBy2(lists.get(i), lists.get(i + 1)));
            }
        }
        return mergeByLists(temp);
    }

    /**
     * 合并两个已排序的链表
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return com.gewuyou.algorithm.problem.ListNode
     * @apiNote 传入两个有序的链表，将其两两合并
     * @since 2022/12/17 15:14
     */
    public ListNode mergeBy2(ListNode list1, ListNode list2) {
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
            ListNode newNode = new ListNode(queue1.poll());
            flagNode.next = newNode;
            flagNode = flagNode.next;
        }
        while (!queue2.isEmpty()) {
            ListNode newNode = new ListNode(queue2.poll());
            flagNode.next = newNode;
            flagNode = flagNode.next;
        }
        // 返回链表
        return head.next;
    }
}
