package com.gewuyou.datastructures.linear;

import java.util.Iterator;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Queue
 * @Description 队列
 * @since 2022/8/31 11:05
 */
public class Queue<T> implements Iterable<T> {

    /**
     * 记录首结点
     */
    private Node head;
    /**
     * 记录最后一个结点
     */
    private Node last;
    /**
     * 记录队列中元素的个数
     */
    private int count;

    /**
     * 节点类
     */
    private class Node {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Queue() {
        //初始化队列
        this.head = new Node(null, null);
        this.last = null;
        this.count = 0;
    }

    /**
     * 判断队列是否为空，是返回true反之为false
     *
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 返回队列中的元素个数
     *
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 向队列中插入元素
     */
    public void enqueue(T data) {
        // 当前尾节点last为null
        if (last == null) {
            last = new Node(data, null);
            head.next = last;
        } else {
            // 当前节点last不为null
            // 标记旧尾节点
            Node flagNode = last;
            // 将新节点变成尾节点
            last = new Node(data, null);
            // 让旧尾节点下一节点指向新节点
            flagNode.next = last;
        }
        // 元素个数++
        count++;
    }

    /**
     * 从队列中取出元素
     *
     * @return
     */
    public T dequeue() {
        //如果队列为null
        if (isEmpty()) {
            return null;
        }
        // 标记第一个数据节点
        Node flagNode = head.next;
        // 移除最先入队的元素
        head.next = flagNode.next;
        // 元素个数--
        count--;
        // 置空该元素索引
        flagNode.next = null;
        // 对删除后进行空校验
        if (isEmpty()) {
            last = null;
        }
        return flagNode.data;
    }

    class QueueIterator implements Iterator {
        // 遍历时当前的节点
        private Node currentNode;

        public QueueIterator() {
            this.currentNode = head;
        }

        /**
         * 遍历终止条件
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            return currentNode.next != null;
        }

        /**
         * 遍历条件
         *
         * @return
         */
        @Override
        public Object next() {
            currentNode = currentNode.next;
            return currentNode.data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }
}
