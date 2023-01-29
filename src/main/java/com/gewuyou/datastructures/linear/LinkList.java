package com.gewuyou.datastructures.linear;


import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName LinkList
 * @Description 单链表
 * @since 2022/8/28 12:31
 */
@Slf4j
public class LinkList<T> implements Iterable<T> {

    /**
     * 头节点
     */
    private Node head;
    /**
     * 单链表长度
     */
    private int length;

    public LinkList() {
        //初始化头结点、
        this.head = new Node(null, null);
        //初始化元素个数
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
     * 清空链表
     */
    public void clear() {
        head.next = null;
        length = 0;
    }

    /**
     * 新增节点
     *
     * @param data 数据
     */
    public void insert(T data) {
        //标记头节点
        Node flagNode = head;
        //通过循环将标记节点指向最后一个节点
        while (flagNode.next != null) {
            flagNode = flagNode.next;
        }
        //经过遍历后标记节点为节点尾部 直接指向新节点
        flagNode.next = new Node(data, null);
        //元素个数+1
        length++;
    }

    /**
     * 获取指定位置index处的元素
     *
     * @param index 指定索引
     * @return 数据
     */
    public T get(int index) {
        // 健壮性增强
        if (index < 0 || index > length || isEmpty()) {
            log.error("输入位置不合法！");
            return null;
        }
        // 标记第一个数据节点
        Node flagNode = head.next;
        // 遍历index次使标记节点指向目标节点
        for (int i = 0; i < index; i++) {
            flagNode = flagNode.next;
        }
        // 返回索引处数据
        return flagNode.data;
    }

    /**
     * 获取倒数index的元素
     *
     * @param index 知道索引
     * @return T
     * @apiNote
     * @since 2022/9/15 10:13
     */
    public T reverseGet(int index) {
        // 健壮性增强
        if (index < 0 || index > length || isEmpty()) {
            throw new RuntimeException("输入位置不合法！");
        }
        // 标记第一个数据节点
        Node flagNode = head.next;
        // 遍历index次使标记节点指向目标节点
        for (int i = 0; i < length - index; i++) {
            flagNode = flagNode.next;
        }
        // 返回索引处数据
        return flagNode.data;
    }

    /**
     * 向指定位置i处添加元素data
     *
     * @param index 位置
     * @param data
     */
    public void insert(int index, T data) {
        // 0 1 2 3
        if (index < 1 || index >= length) {
            throw new RuntimeException("插入位置不合法！");
        }
        // 标记头节点
        Node flagNode = head;
        //for 循环寻找 索引前的节点位置
        for (int i = 0; i < index; i++) {
            flagNode = flagNode.next;
        }
        //标记index目标节点
        Node currNode = flagNode.next;
        //创建新节点接收数据并让下一节点指向目标节点,使自己取代目标节点
        //将标记的目标节点的前一个节点的指向改变为新节点
        flagNode.next = new Node(data, currNode);
        length++;
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * 获取单链表长度
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     * 根据索引删除节点
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        if (index < 0 || index > length || isEmpty()) {
            throw new RuntimeException("输入位置不合法！");
        }
        // 标记头节点
        Node flagNode = head;
        //for 循环寻找 索引前的节点位置
        for (int i = 0; i < index; i++) {
            flagNode = flagNode.next;
        }
        //标记index目标节点
        Node currNode = flagNode.next;
        //将目标节点前的节点指向目标节点后的节点
        flagNode.next = currNode.next;
        // 返回目标节点数据
        return currNode.data;
    }

    /**
     * 返回线性表中首次出现的指定的数据元素的位序号，若不存在，则返回-1
     *
     * @param data
     * @return
     */
    public int indexOf(T data) {
        // 标记第一个数据节点
        Node flagNode = head.next;
        // 遍历index次使标记节点指向目标节点
        for (int i = 1; i <= length; i++) {
            //判断数据是否相同
            if (flagNode.data.equals(data)) {
                // 返回第一个数据的索引
                return i;
            }
            flagNode = flagNode.next;
        }
        return -1;
    }

    /**
     * 对整个链表进行反转
     * 1、调用reverse(Node curr)方法反转每一个节点，从第一个数据节点开始
     * 2、如果发现还有下一个节点。则递归调用reverse(Node curr)对下一个节点反转,返回值是当前节点的上一个节点
     * 3、最终递归递归的出口是最后一个节点，因为没有下一行节点了，当到了出口处，让头节点指向最后一个节点
     * 4、递归开始返回
     */
    public void reverse() {
        // 对代码健壮性作增强
        if (isEmpty()) {
            return;
        }
        reverse(head.next);

    }

    /**
     * 反转链表中的的某个节点curr，并把反转后的curr节点返回
     *
     * @param curr 某个节点
     */
    public Node reverse(Node curr) {
        //终止条件
        if (curr.next == null) {
            head.next = curr;
            return curr;
        }
        //调用reverse(Node curr)对下一个节点反转,返回值是当前节点的上一个节点
        Node currPre = reverse(curr.next);
        //让返回的节点的下一个节点变为当前curr 反转逻辑
        currPre.next = curr;
        //把当前节点的下一个节点变为null
        curr.next = null;
        return curr;
    }

    private class LinkListIterator implements Iterator {
        private Node flagNode;

        public LinkListIterator() {
            //标记头节点
            this.flagNode = head;
        }

        /**
         * 判断当前列表是否遍历完
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            return flagNode.next != null;
        }

        /**
         * 返回第一个数据节点数据
         *
         * @return
         */
        @Override
        public Object next() {
            flagNode = flagNode.next;
            return flagNode.data;
        }


    }

    @Override
    public Iterator<T> iterator() {
        return new LinkListIterator();
    }
}
