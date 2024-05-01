package com.gewuyou.algorithm.problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 *
 * @author gewuyou
 * @since 2024-05-05 下午2:13:51
 */
public class PopulatesNextRightNodePointerIIEachNode {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 获取当前层的节点数
            int size = queue.size();
            Node prev = null;
            // 遍历当前层的节点，设置其下一层的节点
            for (int i = 0; i < size; i++) {
                // 取出当前层的节点
                Node curr = queue.poll();
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;

                if (curr == null) {
                    break;
                }
                // 将当前层的节点的左右子节点加入队列
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return root;
    }
}
