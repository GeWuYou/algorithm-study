package com.gewuyou.algorithm.test;

/**
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName JosephTest
 * @Description 解决循环链表中的约瑟夫问题
 * @since 2022/8/30 14:13
 */
public class JosephTest {
    public static void main(String[] args) {
        // 解决约瑟夫问题
        //1、构建循环链表，包含41个结点，分别存储1~41之间的值
        //用来就首结点
        Node<Integer> first = null;
        //用来记录前一个结点
        Node<Integer> pre = null;
        // 生成循环链表
        for (int i = 1; i < 42; i++) {
            // 如果是第一个节点
            if (i == 1) {
                first = new Node<Integer>(i, null);
                pre = first;
                continue;
            }
            // 如果不是第一个节点

            Node<Integer> newNode = new Node<>(i, null);
            // 将前节点的下一节点设置为新节点
            pre.next = newNode;
            // 将前节点设置为新节点
            pre = newNode;

            // 如果是最后一个节点则需要手动将单链表连接为循环链表
            if (i == 41) {
                pre.next = first;
            }
        }
        //2、需要count计数器，模拟报数
        int count = 0;
        //3、遍历循环链表
        //记录每次遍历拿到的结点，默认从首结点开始
        Node<Integer> curr = first;
        // 记录当前节点的上一个节点
        Node<Integer> before = null;
        // 保证约瑟夫和朋友能活 (curr!=curr.next)只剩约瑟夫
        while (curr != curr.next.next) {
            //模拟报数
            count++;
            //判断当前报数是不是为3
            if (count == 3) {
                //如果是3，则把当前结点删除调用，打印当前结点，重置count=0，让当前结点n后移
                before.next = curr.next;
                System.out.println(curr.item);
                count = 0;
            } else {
                //如果不是3，让before变为当前结点，让当前结点后移；
                before = curr;
            }
            curr = curr.next;
        }
        //打印约瑟夫和他的朋友
        System.out.println(curr.item + ":" + curr.next.item);
    }

    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
