package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 二叉搜索树与双向链表
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BinarySearchTreeAndDoublyLinkedList
 * @apiNote </br>
 * @since 2023/2/1 13:34
 */
public class BinarySearchTreeAndDoublyLinkedList {
    /**
     * 前节点与头节点
     */
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node cur) {
        // 传入节点如果为空则直接返回
        if (cur == null) {
            return;
        }
        // 向左递归
        dfs(cur.left);
        // 如果上一个标记节点不为空
        if (pre != null) {
            // 连接两个节点
            pre.right = cur;

        } else {
            // 否则初始化节点
            head = cur;
        }
        cur.left = pre;
        // 移动标记
        pre = cur;
        // 向右递归
        dfs(cur.right);
    }
}
