package com.gewuyou.datastructures.symbol;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName OrderSymbolTable
 * @Description 有序符号表
 * @since 2022/8/31 12:11
 */
public class OrderSymbolTable<Key extends Comparable<Key>, Value> {

    /**
     * 记录首结点
     */

    private Node head;
    /**
     * 记录符号表中元素的个数
     */

    private int count;

    private class Node {
        /**
         * 键
         */
        public Key key;
        /**
         * 值
         */
        public Value value;
        /**
         * 下一个结点
         */
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.count = 0;
    }

    /**
     * 获取符号表中键值对的个数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 往符号表中插入键值对
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        // 定义两个node变量 分别记录当前节点和当前节点的上一个节点
        //当前节点
        Node currentNode = head.next;
        // 上一节点
        Node precedeNode = head;
        //compareTo() 将调用者与指定对象进行比较以进行排序。返回负整数、零或正整数，因为此对象小于、等于或大于指定对象。
        // 当前节点不为空且传入的key大于当前节点的key
        while (currentNode != null && key.compareTo(currentNode.key) > 0) {
            // 变换当前节点和前节点
            precedeNode = currentNode;
            currentNode = currentNode.next;
        }
        if (currentNode != null && key.compareTo(currentNode.key) == 0) {
            // 如果当前节点的Key和要插入节点的Key相同则替换
            currentNode.value = value;
            return;
        }
        // 如果当前节点的Key和要插入的不一样，此时当前节点key大于传入节点而传入节点大于当前节点的上一节点，所以把新节点插入到CurrentNode前，
        Node newNode = new Node(key, value, currentNode);
        precedeNode.next = newNode;
        // 元素个数++
        count++;
    }

    /**
     * 删除符号表中键为Key的键值对
     *
     * @param key
     */
    public void delete(Key key) {
        // 找到键为key的节点，把节点从链表中删除
        Node flagNode = head;
        while (flagNode != null) {

            // 判断当前节点的下一个节点是否为目标节点。如果是就删除目标节点
            if (flagNode.next.key.equals(key)) {
                flagNode.next = flagNode.next.next;
                // 元素个数--
                count--;
                return;
            }
            //变化标记节点
            flagNode = flagNode.next;
        }
    }

    /**
     * 从符号表中获取key对应的值
     *
     * @param key
     * @return
     */
    public Value getValue(Key key) {
        // 找到Key所在的节点
        Node flagNode = head;
        while (flagNode.next != null) {
            flagNode = flagNode.next;
            if (flagNode.key.equals(key)) {
                return flagNode.value;
            }
        }
        return null;
    }

}
