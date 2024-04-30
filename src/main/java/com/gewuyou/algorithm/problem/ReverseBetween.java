package com.gewuyou.algorithm.problem;
/**
 * 反转部分链表
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ReverseBetween
 * @apiNote </br>
 * @since 2022/11/15 14:59
 */
public class ReverseBetween {
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
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //设置虚拟头节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 找到反转起点
        ListNode pre = dummyNode;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        // 标记当前节点
        ListNode curr = pre.next;
        // 标记当前节点的下一节点
        ListNode currNext;
        for (int i = 0; i < n - m; i++) {
            // 标记下一节点
            currNext = curr.next;
            // 当前节点的下一节点指向下一节点的下一节点
            curr.next = currNext.next;
            // 下一节点指向前节点的下一节点
            currNext.next = pre.next;
            // 前节点指向下一节点
            pre.next = currNext;
        }
        return dummyNode;
    }

    /**
     * 反转部分链表
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        //设置虚拟头节点
        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        // 标记头节点
        ListNode flagNode = head;
        int count = 1;
        // 总长
        int lenth = 0;
        while (flagNode != null) {
            flagNode = flagNode.next;
            lenth++;
        }
        // 计算遍历次数
        for (int i = 0; i < lenth / k; i++) {
            headNode = reverseBetween(headNode.next, count, count + k - 1);
            count += k;
        }
        return headNode.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode flag = node;
        for (int i = 2; i <= 5; i++) {
            ListNode newNode = new ListNode(i);
            flag.next = newNode;
            flag = flag.next;
        }
        ReverseBetween reverseBetween = new ReverseBetween();
        reverseBetween.reverseKGroup(node, 2);
    }

}
