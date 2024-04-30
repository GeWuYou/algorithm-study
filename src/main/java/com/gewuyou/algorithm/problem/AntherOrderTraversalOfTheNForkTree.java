package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N 叉树的前序遍历
 *
 * @author gewuyou
 * @since 2024-04-24 下午12:34:07
 */
public class AntherOrderTraversalOfTheNForkTree {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preOrderTraversal(result, root);
        return result;
    }
    public void preOrderTraversal(List<Integer> result, Node root) {
        if(root == null){
            return;
        }
        result.add(root.val);
        for(Node child : root.children){
            preOrderTraversal(result, child);
        }
    }
}
