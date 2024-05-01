package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.problem.TreeNode;

import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
 *
 * @author gewuyou
 * @since 2024-05-17 下午7:02:29
 */
public class BSTIterator {
    private Stack<TreeNode> rootStack;
    private TreeNode curr;

    public BSTIterator(TreeNode root) {
        // 找到最左边的节点
        curr = root;
        rootStack = new Stack<>();
        getLeft();
    }

    private void getLeft() {
        while (curr.left != null) {
            rootStack.push(curr);
            curr = curr.left;
        }
    }

    public int next() {
        int val = curr.val;
        // 判断当前节点是否有右子树,如果有,则将右子树的最左边节点作为当前节点
        if (curr.right != null) {
            curr = curr.right;
            getLeft();
        } else {
            // 如果当前节点没有右子树则弹出当前节点的父节点作为当前节点
            curr = rootStack.isEmpty() ? null : rootStack.pop();
        }
        return val;
    }

    public boolean hasNext() {
        return !rootStack.isEmpty() || curr != null;
    }
}
