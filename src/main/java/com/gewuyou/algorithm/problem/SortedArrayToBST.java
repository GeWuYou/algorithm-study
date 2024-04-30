package com.gewuyou.algorithm.problem;

/**
 * 将有序数组转换为二叉搜索树
 *
 * @author gewuyou
 * @since 2024-04-06 下午5:59:15
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }

}
