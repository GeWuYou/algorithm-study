package com.gewuyou.algorithm.problem;

/**
 * 约瑟夫问题
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName Josephu
 * @apiNote 单向环形链表解决约瑟夫问题：<p>Josephu问题为：设编号为1，2，...n的n个人围坐一圈，约定编号为k（1<=k<=n）的人从1开始报数，数到m的那个人出列，它的下一位又从1开始报数，数到m的那个人又出列，依次类推，直到所有人出列为止，由此产生一个出队编号的序列。</p>
 * @since 2022/9/16 15:48
 */
public class Josephu {
    /**
     * 问题人数
     */
    private final Integer humans;

    /**
     * 出队位置
     */
    private final Integer position;

    /**
     * 首节点
     */
    Node<Integer> first;

    /**
     * 记录前一个节点
     */
    Node<Integer> pre;

    public Josephu(int humans, Integer position) {
        // 初始化解决方案
        this.humans = humans;
        this.position = position;
        //1、构建循环链表，包含humans个结点，分别存储1~humans之间的值
        init();
        // 解决问题
        solve();
    }

    /**
     * 初始化单向环形链表
     *
     * @apiNote 初始化单向环形链表第二节点至最后
     * @since 2022/9/16 16:05
     */
    private void init() {
        // 初始化第一个节点
        first = new Node<Integer>(1, null);
        pre = first;
        for (int i = 2; i < humans + 1; i++) {
            // 如果不是第一个节点
            Node<Integer> newNode = new Node<>(i, null);
            // 将前节点的下一节点设置为新节点
            pre.next = newNode;
            // 将前节点设置为新节点
            pre = newNode;
            // 如果是最后一个节点则需要手动将单链表连接为循环链表
            if (i == humans) {
                pre.next = first;
            }
        }
    }

    /**
     * 问题处理方法，解决约瑟夫问题
     *
     * @apiNote
     * @since 2022/9/16 16:13
     */
    private void solve() {
        // 解决约瑟夫问题
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
            //判断当前报数是不是为position
            if (count == position) {
                //如果是，则把当前结点删除调用，打印当前结点，重置count=0，让当前结点n后移
                before.next = curr.next;
                System.out.println(curr.item);
                count = 0;
            } else {
                //如果不是position，让before变为当前结点，让当前结点后移；
                before = curr;
            }
            curr = curr.next;
        }
        //打印约瑟夫和他的朋友
        System.out.println(curr.item + ":" + curr.next.item);
    }

    /**
     * 结点类
     *
     * @author GeWuYou
     * @ClassName Node
     * @apiNote
     * @since 2022/9/16 16:13
     */
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

    public static void main(String[] args) {
        Josephu josephu = new Josephu(41, 3);
    }
}
