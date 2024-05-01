package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 *
 * @author gewuyou
 * @since 2024-05-05 下午1:52:09
 */
public class TreesWithSimilarLeaves {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        // 获取两个树的叶子节点值列表
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        // 判断两个列表是否相等
        return leaves1.equals(leaves2);
    }

    private void getLeaves(TreeNode root1, List<Integer> leaves1) {
        if (root1 == null) {
            return;
        }
        if (root1.left == null && root1.right == null) {
            leaves1.add(root1.val);
        }
        getLeaves(root1.left, leaves1);
        getLeaves(root1.right, leaves1);
    }
}
