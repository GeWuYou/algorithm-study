package com.gewuyou.algorithm.problem;

/**
 * 572. 另一棵树的子树
 *
 * @author gewuyou
 * @since 2024-04-23 下午5:35:24
 */
public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }
        return isSameTree(root, subRoot) ||
                isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);

        TreeNode subRoot = new TreeNode(1);

        SubtreeOfAnotherTree solution = new SubtreeOfAnotherTree();
        boolean result = solution.isSubtree(root, subRoot);
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }


}
