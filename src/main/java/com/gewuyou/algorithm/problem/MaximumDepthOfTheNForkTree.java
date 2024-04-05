package com.gewuyou.algorithm.problem;

import java.util.List;

/**
 * 559. N 叉树的最大深度
 *
 * @author gewuyou
 * @since 2024-04-22 下午1:33:18
 */
public class MaximumDepthOfTheNForkTree {
    class Node {
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



    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 1);
    }

    private int dfs(Node root, int max) {
        if (root == null || root.children == null || root.children.isEmpty()) {
            return max;
        }
        max++;
        int newMax = max;
        for (Node child : root.children) {
            newMax = Math.max(newMax, dfs(child, max));
        }
        return newMax;
    }

}
