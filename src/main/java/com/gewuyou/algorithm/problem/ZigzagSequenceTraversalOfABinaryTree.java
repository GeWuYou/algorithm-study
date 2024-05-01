package com.gewuyou.algorithm.problem;

import java.util.*;

/**
 * 103. 二叉树的锯齿形层序遍历
 *
 * @author gewuyou
 * @since 2024-05-01 下午1:37:44
 */
public class ZigzagSequenceTraversalOfABinaryTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 当为偶数时，从左到右，当为奇数时，从右到左
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if ((level&1)==1) {
                Collections.reverse(levelList);
            }
            result.add(levelList);
            level++;
        }
        return result;
    }
}

