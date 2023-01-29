package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最近公共祖先
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ClosestPublicAncestorBinaryTree
 * @apiNote </br>
 * @since 2023/1/4 22:10
 */
public class ClosestPublicAncestorBinaryTree {
    /**
     * 创建两个集合,用于装下深度遍历的节点值
     */
    List<Integer> o1List = new ArrayList<>();
    List<Integer> o2List = new ArrayList<>();
    /**
     * 设置两个全局标记用来标记该节点是否找到
     */
    boolean o1Flag = false;
    boolean o2Flag = false;

    /**
     * @param root TreeNode类
     * @param o1   int整型
     * @param o2   int整型
     * @return int整型
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        DFS(root, o1, o2);
        int i = 0;
        int j = 0;
        while (true) {
            // 如果i与j任意一个值大于对应的集合长度，直接返回
            if (i > o1List.size() - 1) {
                return o1List.get(i - 1);
            }
            if (j > o2List.size() - 1) {
                return o2List.get(j - 1);
            }
            if (o1List.get(i).equals(o2List.get(j))) {
                i++;
                j++;
            } else {
                return o1List.get(i - 1);
            }
        }
    }

    /**
     * 深度遍历二叉树。找到两个目标节点时结束遍历
     *
     * @param root 根节点
     * @param o1   目标值1
     * @param o2   目标值2
     * @apiNote
     * @since 2023/1/4 22:29
     */

    public void DFS(TreeNode root, int o1, int o2) {

        if (root != null) {
            // 检查节点是否寻找完毕
            if (o1Flag && o2Flag) {
                return;
            }
            // 如果目标节点未被找到，将当前节点值加入集合
            if (!o1Flag) {
                o1List.add(root.val);
            }
            if (!o2Flag) {
                o2List.add(root.val);
            }
            // 判断当前节点值是否符合条件
            if (root.val == o1) {
                o1Flag = true;
            }
            if (root.val == o2) {
                o2Flag = true;
            }
            // 递归的调用方法遍历左子树
            DFS(root.left, o1, o2);
            // 递归的调用方法遍历右子树
            DFS(root.right, o1, o2);
            int length;
            // 两层遍历结束后，仍有节点未找到，则进行回溯，并删除当前节点值
            if (!o1Flag) {
                length = o1List.size();
                o1List.remove(length - 1);
            }
            if (!o2Flag) {
                length = o2List.size();
                o2List.remove(length - 1);
            }
        }

    }
}
