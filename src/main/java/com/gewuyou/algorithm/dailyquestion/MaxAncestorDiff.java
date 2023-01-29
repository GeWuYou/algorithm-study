package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.problem.TreeNode;

/**
 * 节点与其祖先之间的最大差值
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName MaxAncestorDiff
 * @apiNote </br>
 * @since 2023/4/18 12:22
 */
public class MaxAncestorDiff {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return 0;
        }
        int diff = Math.max(Math.abs(root.val - max), Math.abs(root.val - min));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        // 向左向右递归
        diff = Math.max(diff, dfs(root.left, max, min));
        diff = Math.max(diff, dfs(root.right, max, min));
        return diff;
    }
}
