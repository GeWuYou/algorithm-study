package com.gewuyou.algorithm.problem;

/**
 * 1022. 从根到叶的二进制数之和
 *
 * @author gewuyou
 * @since 2024-05-14 下午4:35:11
 */
public class SumOfBinaryNumbersFromRootToLeaf {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val;
        }
        return dfs(root.left, new StringBuilder().append(root.val)) + dfs(root.right, new StringBuilder().append(root.val));
    }

    private int dfs(TreeNode root, StringBuilder val) {
        if (root == null) {
            return 0;
        }

        val.append(root.val);
        if (root.left == null && root.right == null) {
            return Integer.parseInt(val.toString(), 2);
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left = dfs(root.left, new StringBuilder(val));
        }
        if (root.right != null) {
            right = dfs(root.right, new StringBuilder(val));
        }
        return left + right;
    }


}
