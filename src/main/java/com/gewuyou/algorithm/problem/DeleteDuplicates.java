package com.gewuyou.algorithm.problem;

/**
 * 删除有序链表中重复的节点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName DeleteDuplicates
 * @apiNote </br>
 * @since 2022/12/21 10:41
 */
public class DeleteDuplicates {

    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 代码健壮性检验
        if (head == null || head.next == null) {
            return head;
        }
        // 为链表前加上表头
        ListNode headNode = new ListNode(0);
        headNode.next = head;
        // 当前节点的下一节点
        ListNode next;
        // 设置当前节点为第一个数据节点
        ListNode curr = head;
        // 设置前一节点为头节点
        ListNode pre = headNode;
        // 遍历链表
        while (curr != null) {
            // 让next指向curr.next
            next = curr.next;
            // 设置信号位，用来判断之前是否有相同的节点
            boolean flag = false;
            while (next != null && curr.val == next.val) {
                next = next.next;
                // 前一个不同节点指向下一个不同节点
                pre.next = next;
                // 如果这个先执行，表示一开始就存在相同的节点
                flag = true;
            }
            // 如果以前没有相同的节点，则pre指向当前节点，保证下次遇到相同的节点设置next
            if (!flag) {
                pre = curr;
            }
            curr = next;
        }
        return headNode.next;
    }
}
