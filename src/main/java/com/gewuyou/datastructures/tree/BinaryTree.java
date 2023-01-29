package com.gewuyou.datastructures.tree;

import com.gewuyou.datastructures.linear.Queue;

/**
 * 二叉查找树(链表)
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName BinaryTree
 * @Description
 * @since 2022/9/1 11:11
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {

    /**
     * 根节点
     */
    private Node root;
    /**
     * 记录树中的元素个数
     */
    private int count;

    private class Node {
        /**
         * 储存键
         */
        private Key key;
        /**
         * 储存值
         */
        private Value value;
        /**
         * 记录左子节点
         */
        private Node left;
        /**
         * 记录右子节点
         */
        private Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 获取树中元素个数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 向树中添加键值对
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        // 向根节点添加键值对并将新树赋值给根节点
        root = put(root, key, value);
    }

    /**
     * 向指定的树X中，添加键值对，并返回添加元素后的新的树
     *
     * @param key
     * @param value
     * @param X
     */
    public Node put(Node X, Key key, Value value) {
        // 如果X子树为空
        if (X == null) {
            count++;
            return new Node(key, value, null, null);
        }
        // 如果X子树不为空
        int compareTo = key.compareTo(X.key);
        // 比较X节点的键和Key的大小
        if (compareTo > 0) {
            // 大于 则继续找X节点的右子树
            X.right = put(X.right, key, value);
        } else if (compareTo == 0) {
            // 等于 则替换X节点的值为value
            X.value = value;
        } else {
            // 小于 则替换X节点的左子树
            X.left = put(X.left, key, value);
        }
        return X;
    }

    /**
     * 查询树中key对应的value
     *
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 从指定的树X中查找key对应的value
     *
     * @param key
     * @param X
     * @return
     */
    public Value get(Node X, Key key) {
        // X树为null
        if (X == null) {
            return null;
        }
        // 如果X子树不为空
        int compareTo = key.compareTo(X.key);
        // 比较X节点的键和Key的大小
        if (compareTo > 0) {
            // 大于 则继续找X节点的右子树
            return get(X.right, key);
        } else if (compareTo == 0) {
            // 等于 则替换X节点的值为value
            return X.value;
        } else {
            // 小于 则继续找X节点的左子树
            return get(X.left, key);
        }
    }

    /**
     * 删除树中key对应的value
     *
     * @param key
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    /**
     * 删除指定树X中key对应的value,并返回删除后的新树
     *
     * @param key
     * @param X
     */
    public Node delete(Node X, Key key) {
        // X树为null
        if (X == null) {
            return null;
        }
        //X树不为null
        // 如果X子树不为空
        int compareTo = key.compareTo(X.key);
        // 比较X节点的键和Key的大小
        if (compareTo > 0) {
            // 大于 则继续找X节点的右子树
            X.right = delete(X.right, key);

        } else if (compareTo == 0) {
            count--;
            // 等于 等于 完成真正删除节点的操作，要删除的节点就是X
            if (X.right == null) {
                // 目标节点在最后一层位于右边 不一定是最右边
                return X.left;
            }

            if (X.left == null) {
                // 目标节点在最后一层位于左边 不一定是最左边
                return X.right;
            }

            // 找到目标子树右边的左子树最小的子树 当然也可以找目标子树左边的右子树最大的子树
            Node minNode = X.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            // 删除右子树中最小的节点
            Node flagNode = X.right;
            // 右子树最小节点没有左节点
            if (flagNode.left == null) {
                // 最小节点也没有右节点
                if (flagNode.right == null) {
                    X.right = null;
                } else {
                    // 最小节点无左节点有右节点
                    X.right = flagNode.right;
                }
            } else {
                // 存在左节点
                while (flagNode.left != null) {
                    if (flagNode.left.left == null) {
                        flagNode.left = null;
                    } else {
                        // 变换flagNode节点
                        flagNode = flagNode.left;
                    }
                }
            }
            // 让X节点的左子树成为minNode的左子树
            minNode.left = X.left;
            // 让X节点的右子树成为minNode的右子树
            minNode.right = X.right;
            // 让X节点的父节点指向minNode节点
            X = minNode;
        } else {
            // 小于 则继续找X节点的左子树
            X.left = delete(X.left, key);
        }
        return X;

    }

    /**
     * 查找整个树中最小的键
     *
     * @return
     */
    public Key min() {
        return min(root).key;
    }

    /**
     * 在指定树X中找出最小键所在的节点
     *
     * @param X
     * @return
     */
    private Node min(Node X) {
        if (X != null && X.left != null) {
            return min(X.left);
        } else {
            return X;
        }
    }

    /**
     * 查找整个树中最大的键
     *
     * @return
     */
    public Key max() {
        return max(root).key;
    }

    /**
     * 在指定树X中找出最大键所在的节点
     *
     * @param X
     * @return
     */
    private Node max(Node X) {
        if (X != null && X.right != null) {
            return max(X.right);
        } else {
            return X;
        }
    }

    /**
     * 获取整个树中所有的键
     * 前序遍历
     *
     * @return 队列
     */
    public Queue<Key> preErgodic() {
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }

    /**
     * 在指定X树中获取所有键，并放到keys队列中
     * 前序遍历
     *
     * @param X 索引节点
     * @param keys 键
     */
    private void preErgodic(Node X, Queue<Key> keys) {
        // 终止条件
        if (X == null) {
            return;
        }
        // 根节点
        keys.enqueue(X.key);
        //递归遍历X节点的左子树
        preErgodic(X.left, keys);
        //递归遍历X节点的右子树
        preErgodic(X.right, keys);
    }

    /**
     * 获取整个树中所有的键
     * 中序遍历
     *
     * @return 队列
     */
    public Queue<Key> midErgodic() {
        Queue<Key> keys = new Queue<>();
        midErgodic(root, keys);
        return keys;
    }

    /**
     * 在指定X树中获取所有键，并放到keys队列中
     * 中序遍历
     *
     * @param X 索引节点
     * @param keys 键
     */
    private void midErgodic(Node X, Queue<Key> keys) {
        // 终止条件
        if (X == null) {
            return;
        }
        //先递归把左子树中的键放到keys中
        midErgodic(X.left, keys);
        // 把当前节点X的键放到keys中
        keys.enqueue(X.key);
        // 把右子树中的键放到keys中
        midErgodic(X.right, keys);
    }

    /**
     * 获取整个树中所有的键
     * 后序遍历
     *
     * @return 队列
     */
    public Queue<Key> afterErgodic() {
        Queue<Key> keys = new Queue<>();
        afterErgodic(root, keys);
        return keys;
    }

    /**
     * 在指定X树中获取所有键，并放到keys队列中
     * 后序遍历
     *
     * @param X 索引节点
     * @param keys 键队列
     */
    private void afterErgodic(Node X, Queue<Key> keys) {
        // 终止条件
        if (X == null) {
            return;
        }
        //先递归把左子树中的键放到keys中
        afterErgodic(X.left, keys);
        // 把右子树中的键放到keys中
        afterErgodic(X.right, keys);
        // 把当前节点X的键放到keys中
        keys.enqueue(X.key);
    }

    /**
     * 获取整个树中所有的键
     * 层序遍历 广度优先思想
     *
     * @return 键队列
     */
    public Queue<Key> layerErgodic() {
        // 定义两个队列，分别存储树中的键和树中的节点
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        // 默认往队列中放根节点
        nodes.enqueue(root);
        // 节约储存资源
        Node flagNode;
        while (!nodes.isEmpty()) {
            // 弹出从队列中弹出节点，把key放到keys中
            flagNode = nodes.dequeue();
            keys.enqueue(flagNode.key);
            // 判断当前节点是否有左子节点，如果有则放入到nodes中
            if (flagNode.left != null) {
                nodes.enqueue(flagNode.left);
            }
            // 判断当前节点是否有右子节点，如果有则放入到nodes中
            if (flagNode.right != null) {
                nodes.enqueue(flagNode.right);
            }
        }
        return keys;
    }

    /**
     * 计算整个树的最大深度
     *
     * @return
     */
    public int maxDepth() {
        return maxDepth(root);
    }

    /**
     * 计算指定树X的最大深度
     *
     * @param X
     * @return
     */
    private int maxDepth(Node X) {
        // 判断空节点
        if (X == null) {
            return 0;
        }
        // 左子树的最大深度
        int maxLeft = 0;
        // 右子树的最大深度
        int maxRight = 0;
        // 计算X节点左子树的最大深度
        if (X.left != null) {
            maxLeft = maxDepth(X.left);
        }
        // 计算X节点右子树的最大深度
        if (X.right != null) {
            maxRight = maxDepth(X.right);
        }
        // 比较左子树最大深度和右子树最大深度，取较大值+1即可
        return maxLeft > maxRight ? maxLeft + 1 : maxRight + 1;

    }
}
