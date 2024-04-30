package com.gewuyou.datastructures.tree;

/**
 * 红黑树
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName RedBlackTree
 * @apiNote 红黑树实现
 * @since 2022/9/6 13:42
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {

    /**
     * 根节点
     */
    private Node root;

    /**
     * 记录树中元素个数
     */
    private int count;

    /**
     * 红色链接标识
     */
    private static final boolean RED = true;

    /**
     * 黑色链接标识
     */
    private static final boolean BLACK = false;

    public RedBlackTree() {
        this.count = 0;
    }

    /**
     * 节点类
     *
     * @author GeWuYou
     * @ClassName 节点类
     * @Description 节点类
     * @since 2022/9/6 13:56
     */
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

        /**
         * 由其父结点指向它的链接的颜色
         */
        private boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }

    /**
     * 判断当前结点的父指向链接是否为红色
     *
     * @param x 当前节点
     * @return boolean
     * @apiNote 是，则返回true反之为false
     * @since 2022/9/6 14:02
     */
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    /**
     * 左旋调整
     *
     * @param h 待调整节点
     * @return com.gewuyou.algorithm.tree.RedBlackTree<Key, Value>.Node
     * @apiNote 将传入节点左旋进行调整
     * 前提：当前结点为h，它的右子结点为x；左旋过程：
     * 1.让x的左子结点变为h的右子结点：h.right=x.left;
     * 2.让h成为x的左子结点：x.left=h;
     * 3.让h的color属性变为x的color属性值：x.color=h.color;
     * 4.让h的color属性变为RED：h.color=true;
     * @since 2022/9/6 14:06
     */
    private Node rotateLeft(Node h) {
        // 此时h节点的右子节点x的color属性为red，因此需要左旋
        // 获取h节点的右子节点。表示为x
        Node x = h.right;
        // 让x节点的左子节点成为h节点的右子节点 因为变换后x的左节点是h，所以应当将变换前的x左节点置于h节点的右边成为右节点
        h.right = x.left;
        // 让h成为x节点的左子节点 使h与x组成3-节点
        x.left = h;
        // 让x节点的color属性等于h节点的color属性 让x变黑树
        x.color = h.color;
        // 让h节点的color属性变为红色 让h变为红树
        h.color = RED;
        // 返回树x
        return x;
    }

    /**
     * 右旋调整
     *
     * @param h 待调整节点
     * @return com.gewuyou.algorithm.tree.RedBlackTree<Key, Value>.Node
     * @apiNote 将传入节点右旋进行调整
     * @since 2022/9/6 14:07
     */
    private Node rotateRight(Node h) {
        // 此时h节点的左子节点x为红树，x的左子节点也为红色，因此需要右旋
        // 获取h节点的左子节点x
        Node x = h.left;
        // 让x节点的右子节点成为h的左子节点
        h.left = x.right;
        // 让h成为x的有子节点
        x.right = h;
        // 让x节点的color属性等于h节点的color属性 将x节点变为黑树
        x.color = h.color;
        // 让h节点的color属性变为红色 将h节点变为红树
        h.color = RED;
        // 返回树x
        return x;
    }

    /**
     * 颜色反转
     *
     * @param h 待反转节点
     * @apiNote 颜色反转, 相当于完成拆分4-结点
     * @since 2022/9/6 14:08
     */
    private void flipColors(Node h) {
        if (h == null) {
            return;
        }
        // 将传入节点的颜色和其子节点的颜色进行反转
        // 黑树父节点变红树
        h.color = RED;
        // 红树左右子节点变黑树
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * 插入元素
     *
     * @param key 键
     * @param val 值
     * @apiNote 在整个树上完成插入操作
     * @since 2022/9/6 14:09
     */
    public void put(Key key, Value val) {
        root = put(root, key, val);
        // 根节点的颜色总是黑色的
        root.color = BLACK;
    }

    /**
     * 向指定节点插入元素
     *
     * @param h   指定节点
     * @param key 键
     * @param val 值
     * @return com.gewuyou.algorithm.tree.RedBlackTree<Key, Value>.Node
     * @apiNote 在指定树中，完成插入操作,并返回添加元素后新的树
     * @since 2022/9/6 14:11
     */
    private Node put(Node h, Key key, Value val) {
        // 非空校验
        if (h == null) {
            // 节点数量++
            count++;
            // 如果h节点为空则返回一个红色节点表明该节点父节点无子节点，所插入的节点是左节点应当为红树
            return new Node(key, val, null, null, RED);
        }
        // 比较h节点的键和key的大小
        int result = key.compareTo(h.key);
        if (result < 0) {
            // 插入数据的节点的key小于当前节点key 继续向左比较 直到找到节点将其替换值并返回新的左节点
            h.left = put(h.left, key, val);
        } else if (result > 0) {
            // 插入数据的节点的key大于当前节点key 继续向右比较 直到找到节点将其替换值并返回新的右节点
            h.right = put(h.right, key, val);
        } else {
            // 插入数据的节点的key等于当前节点key 发生值的替换
            h.value = val;
        }
        // 执行完后当前节点的左节点或者右节点为插入的新节点,此时当前树结构可能需要进行左旋转或者右旋甚至反转
        if (isRed(h.right) && !isRed(h.left)) {
            // 如果h的右子节点颜色为红色，且左子节点为黑色则需要对该节点进行左旋
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            // 如果h节点的左子节点及其左子节点颜色属性都为红色则需要右旋
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            // 如果h节点的左子节点和右子节点的颜色属性均为红色则需要反转
            flipColors(h);
        }
        return h;
    }

    /**
     * 根据key，从树中找出对应的值
     *
     * @param key 键
     * @return Value 值
     * @apiNote 找不到值时返回null
     * @since 2022/9/6 14:13
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 从指定的树x中，找出key对应的值
     *
     * @param x   节点
     * @param key 键
     * @return Value 值
     * @apiNote 从指定的树x中，找出key对应的值，找不到值时返回null
     * @since 2022/9/6 14:14
     */
    public Value get(Node x, Key key) {
        if (x == null) {
            // 如果遍历完还没找到对应的键，则表明没有该值
            return null;
        }
        // 比较x节点的键与当前的键的大小
        int compareTo = key.compareTo(x.key);
        if (compareTo > 0) {
            // 大于0，向右递归查找
            return get(x.right, key);
        } else if (compareTo < 0) {
            // 小于0向左递归查找
            return get(x.left, key);
        } else {
            // 等于0，返回该位置的值
            return x.value;
        }
    }

    /**
     * 树中元素个数
     *
     * @return int
     * @apiNote 获取当前红黑树中元素个数
     * @since 2022/9/6 14:21
     */
    public int size() {
        return count;
    }
}
