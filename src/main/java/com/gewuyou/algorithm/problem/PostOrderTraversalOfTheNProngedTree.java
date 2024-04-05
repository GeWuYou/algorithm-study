package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 *
 * @author gewuyou
 * @since 2024-04-24 下午12:39:56
 */
public class PostOrderTraversalOfTheNProngedTree {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        postOrderTraversal(root, res);
        return res;
    }

    public void postOrderTraversal(Node root, List<Integer> res) {
        for (Node node : root.children) {
            postOrderTraversal(node, res);
        }
        res.add(root.val);
    }
    // public List<Integer> postorder(Node root) {
    //     List<Integer> res = new ArrayList<>();
    //     if (root == null) {
    //         return res;
    //     }
    //     for (Node child : root.children) {
    //         res.addAll(postorder(child));
    //     }
    //     res.add(root.val);
    //     return res;
    // }
}
