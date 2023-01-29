package com.gewuyou.algorithm.problem;


import java.util.Stack;

/**
 * 反转链表
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ReverseLinkedList
 * @apiNote 传入链表将其反转并返回
 * </br>
 * @since 2022/11/15 13:52
 */
public class ReverseLinkedList {

    /**
     * 链表节点
     */
    static class ListNode {
        /**
         * 数据
         */
        int val;
        /**
         * 后继节点
         */
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 反转链表
     *
     * @param head 链表头节点
     * @return com.gewuyou.algorithm.problem.ReverseLinkedList.ListNode
     * @apiNote 将传入的链表头节点反转，返回反转后的头节点
     * @since 2022/11/15 13:56
     */
    public static  ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        // 标记第一个元素
        ListNode flagNode = head;
        // 创建一个栈
        Stack<Integer> stack = new Stack<>();
        // 将元素压入栈中
        while (flagNode != null) {
            stack.push(flagNode.val);
            flagNode = flagNode.next;
        }
        flagNode = head;
        while (!stack.isEmpty()) {
            flagNode.val = stack.pop();
            flagNode = flagNode.next;
        }
        return head;
    }
}

