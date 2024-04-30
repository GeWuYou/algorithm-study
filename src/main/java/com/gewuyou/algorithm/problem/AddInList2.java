package com.gewuyou.algorithm.problem;

/**
 * 链表相加(二)
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName AddInList2
 * @apiNote </br>
 * @since 2022/12/20 10:40
 */
public class AddInList2 {
    /**
     * @param head1 ListNode类
     * @param head2 ListNode类
     * @return ListNode类
     */
    public ListNode addInList(ListNode head1, ListNode head2) {
        // 代码健壮性检验
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        // 定义进位寄存器
        int carry = 0;
        // 定义带有头节点的临时链表接收反转链表
        ListNode temp1 = new ListNode(-9999);
        temp1.next = reverseList(head1);
        ListNode temp2 = new ListNode(-9999);
        temp2.next = reverseList(head2);
        // 手动初始化第一位
        ListNode newNode = new ListNode(-9999);
        ListNode flagNode = newNode;
        // 如果两个链表有不为空的，或者还有进位则继续循环
        while (temp1.next != null || temp2.next != null || carry != 0) {
            // 当某个链表已经到头时，将其位置值设置为0，避免影响后续相加
            if (temp1.next == null) {
                temp1.val = 0;
            }
            if (temp2.next == null) {
                temp2.val = 0;
            }
            // 移动临时节点
            if (temp1.next != null) {
                temp1 = temp1.next;
            }
            if (temp2.next != null) {
                temp2 = temp2.next;
            }
            if (temp1.val + temp2.val + carry < 10) {
                flagNode.next = new ListNode(temp1.val + temp2.val + carry);
                // 重置进位寄存器
                carry = 0;
            } else {
                flagNode.next = new ListNode((temp1.val + temp2.val + carry) % 10);
                // 进位寄存器赋值
                carry = 1;
            }
            // 移动标记节点
            flagNode = flagNode.next;

        }
        // 反转链表
        return reverseList(newNode.next);
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
