package com.gewuyou.algorithm.problem;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * @author gewuyou
 * @since 2024-05-04 下午1:39:03
 */
public class FillsTheNextRightNodePointerForEachNode {
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
        connectHelper(root.left, root.right);
        return root;
    }

    private void connectHelper(Node left, Node right) {
        if (left == null || right == null) {
            return;
        }
        // 设置当前left节点的next为right
        left.next = right;
        // 设置left左子树next
        connectHelper(left.left, left.right);
        // 设置left左子树的右子树节点的next
        connectHelper(left.right, right.left);
        // 设置右子树next
        connectHelper(right.left, right.right);
    }
}
