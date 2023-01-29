package com.gewuyou.algorithm.problem;


import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PreorderTraversalOfBinaryTrees
 * @apiNote </br>
 * @since 2022/12/29 14:04
 */
public class PreorderTraversalOfBinaryTrees {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] preorderTraversal(TreeNode root) {
        // 创建一个数组接收前序遍历结果
        ArrayList<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }


    /**
     * 传入根节点，返回前序遍历结果
     *
     * @param root                        根节点
     * @param result 前序遍历结果储存数组
     * @apiNote
     * @since 2022/12/29 14:24
     */
    public void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            // 前序遍历规则：根左右
            // 将自己的值加入数组
            result.add(root.val);
            // 加入左子节点
            preorderTraversal(root.left, result);
            // 加入右子节点
            preorderTraversal(root.right, result);
        }
    }
}
