package com.gewuyou.algorithm.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输出重建二叉树的右视图
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName OutputRightViewReconstructedBinaryTree
 * @apiNote </br>
 * @since 2023/1/7 15:18
 */
public class OutputRightViewReconstructedBinaryTree {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     *
     * @param pre int整型一维数组 先序遍历
     * @param vin int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    public int[] solve(int[] pre, int[] vin) {
        // 数组判空
        if (pre == null || vin == null || pre.length == 0 || vin.length == 0) {
            return new int[0];
        }
        // 重建二叉树
        TreeNode root = reConstructBinaryTree(pre, vin);
        // 创建辅助队列将根节点加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 创建集合暂存右视图节点值
        List<Integer> rightNodes = new ArrayList<>();
        //层序遍历该二叉树，返回该二叉树的右视图
        layerOrderTraversal(queue, rightNodes);
        // 创建数组
        int[] newNodes = new int[rightNodes.size()];
        // 将集合转换为数组返回
        for (int i = 0; i < rightNodes.size(); i++) {
            newNodes[i] = rightNodes.get(i);
        }
        return newNodes;
    }

    /**
     * 求二叉树的右视图
     *
     * @param queue      当层遍历队列
     * @param rightNodes 右视图节点值集合
     * @apiNote 传入存有二叉树节点队列，返回其右视图值
     * @since 2023/1/7 16:04
     */
    public void layerOrderTraversal(Queue<TreeNode> queue, List<Integer> rightNodes) {
        // 计算本层队列长度
        int size = queue.size();
        // 如果当层队列长度为零说明已经遍历完毕
        if (size == 0) {
            return;
        }
        // 创建下层遍历队列
        Queue<TreeNode> newQueue = new LinkedList<>();
        // 遍历当层遍历队列找出右视图节点值
        while (!queue.isEmpty()) {
            size--;
            // 如果队列索引为0说明已经是本层最右边节点，将该节点值加入数组
            if (size == 0) {
                rightNodes.add(queue.peek().val);
            }
            // 如果该节点左子树不为空，将该节点加入新队列中
            if (queue.peek().left != null) {
                newQueue.offer(queue.peek().left);
            }
            // 如果该节点右子树不为空，将该节点加入新队列中
            if (queue.peek().right != null) {
                newQueue.offer(queue.peek().right);
            }
            // 让该节点出队
            queue.poll();
        }
        // 进行下一层层序遍历
        layerOrderTraversal(newQueue, rightNodes);
    }

    /**
     * 重建二叉树
     *
     * @param pre 前序遍历数组
     * @param vin 中序遍历数组
     * @return com.gewuyou.algorithm.problem.TreeNode
     * @apiNote 传入前序遍历数组与中序遍历数组，返回重建后的二叉树的根节点
     * @since 2023/1/7 15:20
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin) {
        if (pre == null || vin == null || pre.length == 0 || vin.length == 0) {
            return null;
        }
        return reConstructBinaryTree(pre, vin, 0, pre.length - 1, 0, vin.length - 1);
    }

    /**
     * 重建二叉树的递归方法
     *
     * @param pre      前序遍历数组
     * @param vin      中序遍历数组
     * @param preStart 前序遍历数组上界
     * @param preEnd   前序遍历数组下界
     * @param vinStart 中序遍历上界
     * @param vinEnd   中序遍历下界
     * @return com.gewuyou.algorithm.problem.TreeNode
     * @apiNote
     * @since 2023/1/7 15:22
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] vin, int preStart, int preEnd, int vinStart, int vinEnd) {
        // 如果传入上下界越界则返回空节点
        if (preStart > preEnd || vinStart > vinEnd) {
            return null;
        }
        // 创建根节点 前序遍历首节点为根节点
        TreeNode root = new TreeNode(pre[preStart]);
        // 创建遍历中序数组找到根节点所在位置
        int index = 0;
        while (vin[index] != root.val) {
            index++;
        }
        // 计算截取长度
        int lenth = index - vinStart;
        // 分割前序中序数组，递归调用方法返回左右节点
        root.left = reConstructBinaryTree(pre, vin, preStart + 1, preStart + lenth, vinStart, index - 1);
        root.right = reConstructBinaryTree(pre, vin, preStart + lenth + 1, preEnd, index + 1, vinEnd);
        // 返回重建后的二叉树
        return root;
    }
}
