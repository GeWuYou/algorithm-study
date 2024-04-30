package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 反转链表
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ReverseTheLinkedList
 * @apiNote </br>
 * @since 2023/1/19 15:20
 */
public class ReverseTheLinkedList {
    public  ListNode reverseList(ListNode head) {
        // 空指针校验
        if (head == null) {
            return null;
        }
        // 设置两个指针进行节点交换
        ListNode previous = null;
        ListNode next = head.next;
        // 反转链表
        while (head != null) {
            // 让当前节点的下一节点指向上一节点
            head.next = previous;
            // 让上一节点指向当前节点
            previous = head;
            // 移动当前节点
            head = next;
            // 移动下一节点
            if (next != null) {
                next = next.next;
            }
        }
        return previous;
    }
}
