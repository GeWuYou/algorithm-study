package com.gewuyou.datastructures.linear;

import java.util.Iterator;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Stack
 * @apiNote  栈
 * @since 2022/8/31 7:57
 */
public class Stack<T> implements Iterable<T> {

    public Stack() {
        //初始化栈
        this.heand = new Node(null, null);
        this.length = 0;
    }

    /**
     * 节点类
     */
    private class Node {
        /**
         * 节点数据
         */
        T data;
        /**
         * 指向下一个节点的地址
         */
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 头节点
     */
    private Node heand;
    /**
     * 栈高
     */
    private int length;

    /**
     * 判断栈是否为空，是返回true反之为false
     *
     * @return
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * 获取栈中元素个数
     *
     * @return
     */
    public int size() {
        return length;
    }

    /**
     * 弹出栈顶元素
     *
     * @return
     */
    public T pop() {
        // 找到头节点指向的第一个节点
        Node flagNode = heand.next;
        // 栈不能为空
        if (flagNode == null) {
            return null;
        }
        // 将头节点的下一节点指向flagNode的下一节点
        heand.next = flagNode.next;
        // 置空flagNode的指向
        flagNode.next = null;
        // 栈高--
        length--;
        // 返回数据
        return flagNode.data;
    }

    /**
     * 向栈中压入元素
     *
     * @param data
     */
    public void push(T data) {
        //找到头节点指向的第一个节点
        Node flagNode = heand.next;
        // 创建新节点并将下一个节点指向flagNode，将头节点的下一节点指向新节点
        heand.next = new Node(data, flagNode);
        // 栈高++
        length++;
    }

    /**
     * 反转栈
     *
     * @apiNote
     * @since 2022/9/17 13:34
     */
    public void reversion() {
        Stack<T> temps = new Stack<>();
        this.forEach(temps::push);
        this.heand = temps.heand;
    }

    /**
     * 向外部提供遍历方法
     */
    class StackIterator implements Iterator {

        /**
         * 遍历时拿到的当前节点
         */
        private Node currentNode;

        public StackIterator() {
            this.currentNode = heand;
        }

        @Override
        public boolean hasNext() {
            return currentNode.next!=null;
        }

        @Override
        public Object next() {
            currentNode = currentNode.next;
            return currentNode.data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }
}
