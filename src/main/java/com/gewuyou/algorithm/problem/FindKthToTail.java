package com.gewuyou.algorithm.problem;

/**
 * 查找链表倒数k个节点
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName FindKthToTail
 * @apiNote </br>
 * @since 2022/12/19 11:27
 */
public class FindKthToTail {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param pHead ListNode类
     * @param k     int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail(ListNode pHead, int k) {
        //代码健壮性检验
        if (pHead == null) {
            return null;
        }
        // 定义链表长度
        int listLength = 1;
        // 定义临时指针
        ListNode temp = pHead;
        // 遍历链表获取长度
        while (temp.next != null) {
            temp = temp.next;
            listLength++;
        }
        // 重置临时指针
        temp = pHead;
        // 当链表长度小于k时
        if (listLength < k) {
            return null;
        }
        // 计算目标节点位置
        for (int i = 0; i < listLength - k; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
