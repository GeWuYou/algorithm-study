package com.gewuyou.algorithm.problem;

/**
 * 404. 左叶子之和
 *
 * @author gewuyou
 * @since 2024-04-15 下午2:09:27
 */
public class SumOfTheLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            sum += sumOfLeftLeaves(root.left);
        }
        if (root.right != null) {
            sum += sumOfLeftLeaves(root.right);
        }
        return sum;
    }


}
