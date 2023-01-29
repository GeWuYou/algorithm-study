package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 查找链表倒数K个节点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FindTheLastKNodesOfTheLinkedList
 * @apiNote </br>
 * @since 2023/1/29 11:55
 */
public class FindTheLastKNodesOfTheLinkedList {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 定义快指针
        ListNode fastPointer = head;
        // 定义慢指针
        ListNode slowPointer = head;
        // 先让快指针移动k个位置 index = k 再同时移动快慢指针，当快指针到达边界时，此时二者相差k位，即慢指针开始的节点为倒数第k个节点
        for (int i = 0; i < k; i++) {
            // 移动快指针
            fastPointer = fastPointer.next;
        }
        while (fastPointer!=null) {
            // 同时移动快慢指针
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        // 返回慢指针处的值
        return slowPointer;
    }
}
