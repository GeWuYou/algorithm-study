package com.gewuyou.algorithm.dailyquestion;

/**
 * 二叉树着色游戏
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BinaryTreeColoringGame
 * @apiNote </br>
 * @since 2023/2/3 9:58
 */
public class BinaryTreeColoringGame {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 一号玩家的选择
     */
    TreeNode xNode;

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // 找到一号玩家选择的节点
        find(root, x);
        // 计算一号玩家的左右子树的总节点数
        int leftSize = dfs(xNode.left);
        int rightSize = dfs(xNode.right);
        // 如果x节点左子节点数大于总节点数的一半
        if (leftSize >= ((n + 1) / 2)) {
            return true;
        }
        // 如果x节点右子节点数大于总节点数的一半
        if (rightSize >= ((n + 1) / 2)) {
            return true;
        }
        // 如果其他节点大于x节点中所有节点数
        return (n - (leftSize + rightSize + 1)) >= ((n + 1) / 2);
    }

    public void find(TreeNode root, int x) {
        // 判空
        if (root == null||xNode!=null) {
            return;
        }
        // 赋值
        if (root.val == x) {
            xNode = root;
            return;
        }
        // 向左右递归
        find(root.left, x);
        find(root.right, x);
    }

    /**
     * 深度优先遍历
     *
     * @param root 根节点
     * @return int 该子树的总节数
     * @apiNote
     * @since 2023/2/3 10:04
     */

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root.left) + dfs(root.right) + 1;
    }
}
