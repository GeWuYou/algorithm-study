package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 删除链表的节点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName DeleteLinkedListNode
 * @apiNote </br>
 * @since 2023/1/29 9:18
 */
public class DeleteLinkedListNode {
    public static ListNode deleteNode(ListNode head, int val) {
        // 设置虚拟头节点
        ListNode virtualHeadNode = new ListNode(Integer.MIN_VALUE);
        virtualHeadNode.next = head;
        // 当前节点
        ListNode curr = virtualHeadNode;
        while (curr.next != null) {
            // 找到该节点
            if (curr.next.val == val) {
                // 如果目标节点下一个指向为NULL则置空
                if (curr.next.next == null) {
                    curr.next = null;
                    return virtualHeadNode.next;
                }
                // 如果目标节点下一个指向不为空
                else {
                    curr.next = curr.next.next;
                    return virtualHeadNode.next;
                }
            }
            curr = curr.next;
        }
        return virtualHeadNode.next;
    }
}
