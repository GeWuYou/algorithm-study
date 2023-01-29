package com.gewuyou.algorithm.test;

import com.gewuyou.datastructures.linear.Queue;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName PagerFoldingTest
 * @Description 折纸问题
 * @since 2022/9/2 8:32
 */
public class PagerFoldingTest {

    /**
     * @author GeWuYou
     * @ClassName Node
     * @Description 节点类
     * @since 2022/9/2 9:55
     */
    private static class Node<T> {
        /**
         * 存储元素
         */
        private T t;

        /**
         * 左节点
         */
        private Node left;
        /**
         * 右节点
         */
        private Node right;

        public Node(T t, Node left, Node right) {
            this.t = t;
            this.left = left;
            this.right = right;
        }
    }


    public static void main(String[] args) {

        //模拟这只过程，产生树
        Node<String> tree = createTree(2);
        //遍历树，打印每个结点
        printTree(tree);
    }

    /**
     * 产生树方法
     *
     * @param count
     * @return com.gewuyou.algorithm.test.PagerFoldingTest.Node
     * @apiNote 通过模拟对折N次纸，产生树
     * @since 2022/9/2 9:55
     */
    public static Node<String> createTree(int count) {
        //定义根节点
        Node<String> root = null;
        for (int i = 0; i < count; i++) {

            // 1、当前树是空树，第一次对折
            if (i == 0) {
                root = new Node<String>("down", null, null);
            } else {
                // 2、当前不是第一次对折
                // 定义一个辅助队列，通过层序遍历思想，找到叶子节点，对叶子节点添加子节点
                Queue<Node> nodes = new Queue<>();
                // 3、默认将根节点加入辅助队列
                nodes.enqueue(root);

                // 循环遍历队列
                Node<String> flagNode;
                while (!nodes.isEmpty()) {
                    // 从队列中弹出一个节点
                    flagNode = nodes.dequeue();
                    // 如果有左子节点，将其放入到队列中
                    if (flagNode.left != null) {
                        nodes.enqueue(flagNode.left);
                    }
                    // 如果有右子节点，将其放入到队列中
                    if (flagNode.right != null) {
                        nodes.enqueue(flagNode.right);
                    }
                    // 如果同时没有左子节点和右子节点,证明该子节点为叶子节点,只需要给该节点添加左子节点
                    if (flagNode.right == null && flagNode.left == null) {
                        flagNode.right = new Node<String>("up", null, null);
                        flagNode.left = new Node<String>("down", null, null);
                    }
                }
            }

        }
        return root;
    }


    /**
     * 打印树
     *
     * @param root
     * @apiNote 打印树中每一个节点到控制台
     * @since 2022/9/2 10:52
     */
    public static void printTree(Node<String> root) {
        // 需要使用中序遍历完成
        if (root == null) {
            return;
        }
        // 打印左子树的每一个节点
        if (root.left != null) {
            printTree(root.left);
        }
        // 打印当前节点
        System.out.print(root.t + " ");
        // 打印右子树的每一个节点
        if (root.right != null) {
            printTree(root.right);
        }

    }
}
