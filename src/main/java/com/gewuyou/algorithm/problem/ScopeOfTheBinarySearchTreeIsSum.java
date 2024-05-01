package com.gewuyou.algorithm.problem;

/**
 * 938. 二叉搜索树的范围和
 *
 * @author gewuyou
 * @since 2024-05-09 下午3:43:24
 */
public class ScopeOfTheBinarySearchTreeIsSum {
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val >= low&&root.val<=high) {
            sum+=root.val;
        }
        rangeSumBST(root.left,low,high);
        rangeSumBST(root.right,low,high);
        return sum;
    }


}
