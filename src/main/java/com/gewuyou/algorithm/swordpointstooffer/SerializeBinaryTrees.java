package com.gewuyou.algorithm.swordpointstooffer;

import com.gewuyou.algorithm.problem.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化二叉树
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SerializeBinaryTrees
 * @apiNote </br>
 * @since 2023/2/28 18:50
 */
public class SerializeBinaryTrees {
    Queue<TreeNode> queue = new LinkedList<>();
    String nullStr = "null";

    public String serialize(TreeNode root) {
        // 判空
        if (root == null) {
            return "";
        }
        // 创建字符串构建类
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        // 层序遍历
        while (!queue.isEmpty()) {
            // 弹出当前队列队头元素
            TreeNode temp = queue.poll();
            // 判空
            if (temp != null) {
                sb.append(temp.val).append(",");
                queue.offer(temp.left);
                queue.offer(temp.right);
            } else {
                sb.append("null").append(",");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    public TreeNode deserialize(String data) {
        // 判空
        if (data == null || data.length() == 0) {
            return null;
        }
        // 切割字符串
        String[] split = data.split(",");
        // 创建根节点
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        // 创建变量记录数组下标
        int index = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 接收弹出的节点
            TreeNode temp = queue.poll();
            // 判断左节点是否不为null
            if (!nullStr.equals(split[index])) {
                // 连接节点
                temp.left = new TreeNode(Integer.parseInt(split[index]));
                // 将该节点加入队列
                queue.offer(temp.left);
            }
            // 移动索引
            index++;
            // 判断右节点是否不为null
            if (!nullStr.equals(split[index])) {
                // 连接节点
                temp.right = new TreeNode(Integer.parseInt(split[index]));
                // 将该节点加入队列
                queue.offer(temp.right);
            }
            // 移动索引
            index++;
        }
        // 返回根节点
        return root;
    }
}
