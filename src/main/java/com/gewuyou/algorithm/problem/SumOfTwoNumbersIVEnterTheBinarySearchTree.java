package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 653. 两数之和 IV - 输入二叉搜索树
 *
 * @author gewuyou
 * @since 2024-04-26 下午1:36:50
 */
public class SumOfTwoNumbersIVEnterTheBinarySearchTree {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorderTraversal(root,arr);
        Collections.sort(arr);
        int left = 0, right = arr.size() - 1;
        while (left < right) {
            int sum = arr.get(left) + arr.get(right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }
}
