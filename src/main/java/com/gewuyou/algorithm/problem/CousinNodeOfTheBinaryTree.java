package com.gewuyou.algorithm.problem;

/**
 * 993. 二叉树的堂兄弟节点
 *
 * @author gewuyou
 * @since 2024-05-12 下午1:49:32
 */
public class CousinNodeOfTheBinaryTree {
    private TreeNode xParent;
    private TreeNode yParent;
    private int depthX;
    private int depthY;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null, 0, x, y);
        return xParent != null && yParent != null && depthX == depthY && xParent != yParent;
    }


    private void dfs(TreeNode root, TreeNode parent, int depth, int x, int y) {
        if (root == null || xParent != null && yParent != null) {
            return;
        }
        depth++;
        if (root.val == x) {
            xParent = parent;
            depthX = depth;
        } else if (root.val == y) {
            yParent = parent;
            depthY = depth;
        }
        dfs(root.left, root, depth, x, y);
        dfs(root.right, root, depth, x, y);

    }
}



