package com.gewuyou.algorithm.problem;

/**
 * 删除链表的倒数第n个节点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RemoveNthFromEnd
 * @apiNote </br>
 * @since 2022/12/19 11:59
 */
public class RemoveNthFromEnd {
    /**
     * @param head ListNode类
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //代码健壮性检验
        if (head == null) {
            return null;
        }
        if (n == 0) {
            return head;
        }
        // 定义链表长度
        int listLength = 1;
        // 定义临时指针
        ListNode temp = head;
        // 遍历链表获取长度
        while (temp.next != null) {
            temp = temp.next;
            listLength++;
        }
        // 重置临时指针
        temp = head;
        // 当链表长度小于k时
        if (listLength < n) {
            return null;
        } else if (listLength == n) {
            return head.next;
        }
        // 计算目标节点位置遍历到前一位
        for (int i = 0; i < listLength - n - 1; i++) {
            temp = temp.next;
        }
        // 删除节点
        temp.next = temp.next.next;
        return head;
    }
}
