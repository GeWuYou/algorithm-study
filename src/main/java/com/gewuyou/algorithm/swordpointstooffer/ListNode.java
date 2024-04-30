package com.gewuyou.algorithm.swordpointstooffer;

/**
 * 力扣链表节点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName ListNode
 * @apiNote </br>
 * @since 2022/11/17 16:37
 */
public class ListNode {

    /**
     * 数据
     */
    public int val;
    /**
     * 下一节点索引
     */
    public ListNode next = null;

    /**
     * 构造方法
     * @param val 数据
     */
    public ListNode(int val) {
        this.val = val;
    }
}
