package com.gewuyou.algorithm.problem;

/**
 * 二叉搜索树与双向链表
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BinarySearchTreeAndBidirectionalLinkedList
 * @apiNote </br>
 * @since 2022/12/31 17:16
 */
public class BinarySearchTreeAndBidirectionalLinkedList {
    public TreeNode Convert(TreeNode pRootOfTree) {
        // 排除其他情况
        if (pRootOfTree == null) {
            return null;
        }
        transform(pRootOfTree);
        TreeNode flag = pRootOfTree;
        while (flag.left != null) {
            flag = flag.left;
        }
        return flag;
    }

    /**
     * 将传入的树转换成双向链表
     *
     * @param root 根节点
     * @return TreeNode
     * @apiNote
     * @since 2022/12/31 17:18
     */
    public TreeNode transform(TreeNode root) {
        if (root != null) {
            if (root.left != null) {
                // 返回值为左子树的右子节点的父节点
                TreeNode transform = transform(root.left);
                // 如果返回的节点不为空且该节点存在右子节点才符合条件，否则该节点度为1
                if (transform != null && transform.right != null) {
                    // 让该节点的右子节点的后继指向当前根节点
                    transform.right.right = root;
                    // 让当前根节点的前驱指向该节点的右子节点
                    root.left = transform.right;
                } else {
                    // 将左子树的右驱指向根节点(根节点左驱已经指向了左子节点)
                    root.left.right = root;
                }
            }
            // 递归的调用转换方法传入右子树
            if (root.right != null) {
                // 返回值为右子树的左子节点的父节点
                TreeNode transform = transform(root.right);
                // 如果返回的节点不为空且该节点存在左子节点才符合条件，否则该节点度为1
                if (transform != null && transform.left != null) {
                    // 让该节点的左子节点的前驱指向当前根节点
                    transform.left.left = root;
                    // 让当前根节点的后继指向该节点的左子节点
                    root.right = transform.left;
                } else {
                    // 将右子树的左驱指向根节点(根节点右驱已经指向了右子节点)
                    root.right.left = root;
                }
            }
            // 当前节点为叶子节点，返回null
            if (root.right == null && root.left == null) {
                return null;
            }
            // 返回当前节点
            return root;
        }
        return null;
    }
}
