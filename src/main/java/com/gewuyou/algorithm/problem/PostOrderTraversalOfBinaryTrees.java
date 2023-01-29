package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PostOrderTraversalOfBinaryTrees
 * @apiNote </br>
 * @since 2022/12/29 15:18
 */
public class PostOrderTraversalOfBinaryTrees {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] postorderTraversal(TreeNode root) {
        // 创建一个数组接收后序遍历结果
        ArrayList<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 传入根节点，返回后序遍历结果
     *
     * @param root   根节点
     * @param result 后序遍历结果储存数组
     * @apiNote
     * @since 2022/12/29 14:24
     */
    public void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            // 后序遍历规则：左右根
            // 加入左子节点
            postorderTraversal(root.left, result);
            // 加入右子节点
            postorderTraversal(root.right, result);
            // 将自己的值加入数组
            result.add(root.val);
        }
    }
}
