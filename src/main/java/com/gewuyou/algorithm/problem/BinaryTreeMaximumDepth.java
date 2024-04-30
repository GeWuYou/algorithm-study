package com.gewuyou.algorithm.problem;

/**
 * 二叉树的最大深度
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BinaryTreeMaximumDepth
 * @apiNote 使用深度优先遍历计算二叉树最大深度
 * @since 2022/12/30 20:09
 */
public class BinaryTreeMaximumDepth {
    /**
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth(TreeNode root) {
        return DFS(root, 0);
    }

    /**
     * 深度优先遍历
     *
     * @param root  根节点
     * @param depth 深度
     * @return int 最大深度
     * @apiNote
     * @since 2022/12/30 21:02
     */
    public int DFS(TreeNode root, int depth) {
        if (root != null) {
            // 深度自增
            depth++;
            // 创建变量接收左右子树最大深度
            int leftDepth = 0;
            int rightDepth = 0;
            if (root.left != null) {
                // 如果左子树不为空
                leftDepth = DFS(root.left, depth);
            }
            if (root.right != null) {
                // 如果右子树不为空
                rightDepth = DFS(root.right, depth);
            }
            // 比较本层与左右子树最大深度，防止无左右子树导致返回的层数为0
            return Math.max(Math.max(leftDepth, rightDepth), depth);
        }
        return depth;
    }
}
