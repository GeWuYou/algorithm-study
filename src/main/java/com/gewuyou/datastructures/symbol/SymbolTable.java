package com.gewuyou.datastructures.symbol;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName SymbolTable
 * @Description 符号表
 * @since 2022/8/31 12:11
 */
public class SymbolTable<Key, Value> {

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

    public SymbolTable() {
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
        // 符号表中已经存在了键为Key的键值对，那么只需要找到该节点，替换值为Value即可
        Node flatNode = head;
        while (flatNode.next != null) {
            // 变换flagNode
            flatNode = flatNode.next;
            if (flatNode.key.equals(key)) {
                flatNode.value = value;
                return;
            }
        }
        // 如果符号表中不存在键为Key的键值对，只需要创建新的节点，保存要插入键值对，将新节点插入链表的头部 head.next = 新节点即可
        Node newNode = new Node(key, value, null);
        // 将标记节点指向第一个数据节点
        flatNode = head.next;
        // 将新节点的下一节点指向原来的第一个数据节点
        newNode.next = flatNode;
        // 将头节点的下一个节点指向新节点
        head.next = newNode;
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
