package com.gewuyou.algorithm.problem;

/**
 * 判断链表是否为回文结构
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName IsPail
 * @apiNote </br>
 * @since 2022/12/21 8:42
 */
public class IsPail {
    /**
     * @param head ListNode类 the head
     * @return bool布尔型
     */
    public boolean isPail(ListNode head) {
        // 代码健壮性检验
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        // 头节点
        ListNode temp1 = head;
        ListNode temp2 = new ListNode(-9999);
        ListNode flag = temp2;
        // 复制一份链表
        while (true) {
            temp2.next = new ListNode(temp1.val);
            if (temp1.next == null) {
                break;
            }
            temp2 = temp2.next;
            temp1 = temp1.next;
        }
        // 将传入的链表反转
        ListNode reverseList = reverseList(head);

        while (flag.next != null) {
            flag = flag.next;
            if (flag.val != reverseList.val) {
                return false;
            }
            reverseList = reverseList.next;
        }
        return true;
    }

    /**
     * 反转链表
     *
     * @param head 第一个数据节点
     * @return com.gewuyou.algorithm.problem.ListNode
     * @apiNote
     * @since 2022/12/20 10:42
     */
    public ListNode reverseList(ListNode head) {
        // 代码健壮性检验
        if (head == null) {
            return null;
        }
        // 标记当前节点
        ListNode current = head;
        // 设置前一节点
        ListNode previous = null;
        while (current != null) {
            //记录当前节点的下一个节点
            ListNode temp = current.next;
            //让当前节点指向前一个节点
            current.next = previous;
            //将前一个节点设置为当前节点
            previous = current;
            //将当前节点向下移动
            current = temp;
        }
        // 当当前节点为空时，表示当前节点到原链表尾+1位置了，返回前一个节点即是反转后的链表头
        return previous;
    }
}
