package com.gewuyou.datastructures.linear;

import java.util.Iterator;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName TwoWayLinkList
 * @Description 双链表
 * @since 2022/8/28 16:01
 */
public class TwoWayLinkList<T> implements Iterable<T> {
    /**
     * 首节点
     */
    private final Node first;
    /**
     * 尾节点
     */
    private Node last;

    /**
     * 链表长度
     */
    private int length;

    public TwoWayLinkList() {
        // 初始化头节点
        this.first = new Node(null, null, null);
        // 初始化尾节点
        this.last = null;
        // 初始化元素个数
        this.length = 0;
    }


    private class Node {
        /**
         * 存储数据
         */
        T data;
        /**
         * 指向下一个节点
         */
        Node next;
        /**
         * 指向上一个节点
         */
        Node previous;

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }

    /**
     * 空置线性表
     */
    public void clear() {
        // 将尾节点置空
        last = null;
        // 将首节点下一个指向置空
        first.next = null;
        length = 0;
    }

    /**
     * 判断线性表是否为空，是返回true,否返回false
     *
     * @return
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * 获取线性表中元素的个数
     *
     * @return
     */
    public int length() {
        return length;
    }

    /**
     * 读取并返回线性表中的第index个元素的值
     *
     * @param index
     * @return
     */
    public T get(int index) {

        Node flagNode = first;
        for (int i = 0; i < index + 1; i++) {
            flagNode = flagNode.next;
        }
        // 得到的节点是目标节点
        return flagNode.data;
    }

    /**
     * 往线性表中添加一个元素
     */
    public void insert(T data) {
        // 如果链表为空
        if (isEmpty()) {
            // + 创建新节点 传入数据 新节点上一节点指向头节点 下一节点指向空
            Node newNode = new Node(data, null, first);
            // + 让新节点成为尾节点
            last = newNode;
            // + 让头节点下一节点指向新节点
            first.next = newNode;
        } else {
            // 如果链表不为空
            // + 标记原本的尾节点
            Node flagNode = last;
            // + 创建新节点
            Node newNode = new Node(data, null, flagNode);
            // + 让当前的尾节点的下一节点指向新节点
            flagNode.next = newNode;
            // + 让新节点成为当前尾节点
            last = newNode;
        }
        // 元素个数增加
        length++;
    }

    /**
     * 在线性表的第index个元素之前插入一个值为data的数据元素。
     *
     * @param index
     * @param data
     */
    public void insert(int index, T data) {
        // 输入检查
        if (index > length || index < 1) {
            throw new RuntimeException("输入索引不合法！！！");
        }
        // 创建标记节点标记头节点
        Node flagNode = first;
        // 查找目标位置节点的上一节点
        for (int i = 0; i < index; i++) {
            flagNode = flagNode.next;
        }
        // 找到目标节点 此时flagNode标记的是目标节点的上一个节点(比如索引5，加上头结点需要找6次)
        // 创建新节点接收数据
        Node newNode = new Node(data, flagNode.next, flagNode);
        // 将目标节点的上一节点的下一节点指向新节点 flagNode.next 目标节点
        flagNode.next = newNode;
        // 将目标节点的上一节点指向新节点
        flagNode.next.previous = newNode;
        length++;
    }

    /**
     * 删除并返回线性表中第index个数据元素。
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        // 对传入索引进行校验
        if (index < 0 || index > length) {
            throw new RuntimeException("输入索引不合法！！！");
        }
        // 移除尾部节点
        if (index == length) {
            // 标记旧的尾节点
            Node flagNode = last;
            T flagData = last.data;
            // 将尾节点前移
            last = last.previous;
            // 移除指向旧尾节点
            flagNode.previous.next = null;
            // 移除旧尾节点本身指向
            flagNode.previous = null;
            length--;
            return flagData;
        }
        // 标记头节点
        Node flagNode = first;
        for (int i = 0; i < index + 1; i++) {
            flagNode = flagNode.next;
        }
        // 由于循环多遍历了一次，得到的flagNode为目标节点
        // 将目标节点的上一节点的下一节点指向目标节点的下一节点
        flagNode.previous.next = flagNode.next;
        // 将目标节点的下一节点的上一节点指向目标节点的上一节点
        flagNode.next.previous = flagNode.previous;
        // 置空目标节点的上一节点和下一节点的索引
        flagNode.next = null;
        flagNode.previous = null;
        // 将长度减小1
        length--;
        // 返回目标节点数据
        return flagNode.data;
    }

    /**
     * 返回线性表中首次出现的指定的数据元素的位序号，若不存在，则回-1。
     *
     * @param data
     * @return
     */
    public int indexOf(T data) {
        Node flagNode = first.next;
        for (int i = 1; flagNode.next != null; i++) {

            if (flagNode.data.equals(data)) {
                return i;
            }
            flagNode = flagNode.next;
        }
        return -1;
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return first.next.data;
    }

    /**
     * 获取最后一个元素
     *
     * @return
     */
    public T getLast() {
        return isEmpty() ? null : last.data;
    }

    private class TwoWayLinkIterator implements Iterator {
        private Node node;

        public TwoWayLinkIterator() {
            this.node = first;
        }

        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new TwoWayLinkIterator();
    }
}
