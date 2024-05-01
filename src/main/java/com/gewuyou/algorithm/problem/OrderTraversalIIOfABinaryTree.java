package com.gewuyou.algorithm.problem;

import java.util.*;

/**
 * 107. 二叉树的层序遍历 II
 *
 * @author gewuyou
 * @since 2024-05-02 下午3:43:46
 */
public class OrderTraversalIIOfABinaryTree {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        Collections.reverse(res);
        return res;
    }
}
