package com.gewuyou.algorithm.problem;

/**
 * 109. 有序链表转换二叉搜索树
 *
 * @author gewuyou
 * @since 2024-05-03 下午3:39:39
 */
public class OrderedLinkedListTransformsBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        // 单节点情况下直接返回根节点
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        // 定义快慢指针
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // 用于记录 slow 的前一个节点
        // 找到链表的中间节点
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 切断链表，prev 指向左子链表的尾部
        prev.next = null;
        // 合并左右子树
        TreeNode root = new TreeNode(slow.val);
        // 递归转换左子树
        TreeNode leftTr = sortedListToBST(head);
        // 递归转换右子树
        TreeNode rightTr = sortedListToBST(slow.next);

        root.left = leftTr;
        root.right = rightTr;
        return root;
    }
}
