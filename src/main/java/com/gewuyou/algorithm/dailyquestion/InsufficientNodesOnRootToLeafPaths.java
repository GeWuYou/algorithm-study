package com.gewuyou.algorithm.dailyquestion;

import com.gewuyou.algorithm.problem.TreeNode;

/**
 * 根到叶路径上的不足节点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName InsufficientNodesOnRootToLeafPaths
 * @apiNote </br>思路：
 * @since 2023/5/22 11:07
 */
public class InsufficientNodesOnRootToLeafPaths {
    public static TreeNode sufficientSubset(TreeNode root, int limit) {
        boolean haveSufficient = checkSufficientLeaf(root, 0, limit);
        return haveSufficient ? root : null;
    }

    private static boolean checkSufficientLeaf(TreeNode root, int sum, int limit) {
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return sum + root.val>=limit;
        }
        boolean haveSufficientLeft = checkSufficientLeaf(root.left,sum+root.val,limit);
        boolean haveSufficientRight = checkSufficientLeaf(root.right,sum+root.val,limit);
        if(!haveSufficientLeft){
            root.left = null;
        }
        if(!haveSufficientRight){
            root.right = null;
        }
        return haveSufficientLeft||haveSufficientRight;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(-99);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(-99);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(-99);
        TreeNode node11 = new TreeNode(-99);
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node5.right = node11;
        TreeNode node12 = new TreeNode(12);
        TreeNode node13 = new TreeNode(13);
        TreeNode node14 = new TreeNode(-99);
        TreeNode node15 = new TreeNode(14);
        node3.left = node6;
        node3.right = node7;
        node6.left = node12;
        node6.right = node13;
        node7.left = node14;
        node7.right = node15;
        sufficientSubset(node1,1);
    }
}
