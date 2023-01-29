package com.gewuyou.algorithm.problem;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SerializeBinaryTree
 * @apiNote </br>
 * @since 2023/1/6 11:26
 */
@Slf4j
public class SerializeBinaryTree {
    /**
     * 空节点占位字符串
     */
    String nullNode = "#";

    /**
     * 序列化二叉树
     *
     * @param root 二叉树根节点
     * @return java.lang.String
     * @apiNote 传入二叉树根节点，将该二叉树序列化成字符串
     * @since 2023/1/6 11:28
     */
    public String Serialize(TreeNode root) {
        // 创建空串
        String result = "";
        // 如果当前节点为空，返回空串
        if (root == null) {
            return result;
        }
        // 创建一个队列进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点加入队列
        queue.offer(root);
        //使用while循环进行层序遍历
        while (!queue.isEmpty()) {
            // 弹出当前队列中的节点，并使用临时节点接收
            TreeNode temp = queue.poll();
            // 如果当前弹出的节点不为空则将当前值加入字符串中
            if (temp != null) {
                result += temp.val + ",";
                queue.offer(temp.left);
                queue.offer(temp.right);
            } else {
                result += nullNode + ",";
            }
        }
        return result.substring(0, result.length() - 1);
    }


    /**
     * 反序列化二叉树
     *
     * @param str 序列化好的二叉树字符串
     * @return com.gewuyou.algorithm.problem.TreeNode
     * @apiNote 传入序列化后的二叉树字符串，并将其转换成二叉树，返回该二叉树根节点
     * @since 2023/1/6 11:29
     */
    public TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        // 切割字符串
        String[] sb = str.split(",");
        // 创建根节点
        TreeNode root = new TreeNode(Integer.parseInt(sb[0]));
        // 创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 创建变量记录数组下标
        int index = 1;
        // 将根节点加入队列
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 创建一个临时节点接收出队节点
            TreeNode temp = queue.poll();
            // 如果在数组中该索引处的元素不为"#"则说明该节点存在
            if (!nullNode.equals(sb[index])) {
                // 创建该节点并将该节点加入队列中
                temp.left = new TreeNode(Integer.parseInt(sb[index]));
                queue.offer(temp.left);
            }
            // 移动索引
            index++;
            if (!nullNode.equals(sb[index])) {
                // 创建该节点并将该节点加入队列中
                temp.right = new TreeNode(Integer.parseInt(sb[index]));
                queue.offer(temp.right);
            }
            // 移动索引
            index++;
        }
        // 返回根节点
        return root;
    }
}
