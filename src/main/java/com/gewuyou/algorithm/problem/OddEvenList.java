package com.gewuyou.algorithm.problem;

/**
 * 链表的奇偶重排
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName OddEvenList
 * @apiNote </br>
 * @since 2022/12/21 9:38
 */
public class OddEvenList {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList(ListNode head) {
        // 健壮性检验
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        // 获取链表长度
        int length = count(head);
        int[] oldList = new int[length + 1];
        ListNode flag = head;
        // 将链表数据倒入数组中
        for (int i = 1; i <= length; i++) {
            oldList[i] = flag.val;
            flag = flag.next;
        }
        // 创建一个新数组
        int []newList = new int[length+1];
        // 创建一个计数器
        int count = 1;
        // 奇数重排
        for (int i = 1; i <= length; i+=2) {
            newList[count] = oldList[i];
            count++;
        }
        // 偶数重排
        for (int i = 2; i <= length; i+=2) {
            newList[count] = oldList[i];
            count++;
        }
        flag = head;
        // 遍历数组，更新链表
        for (int i = 1; i <= length; i++) {
            flag.val = newList[i];
            flag = flag.next;
        }
        return head;
    }

    /**
     * 获取链表长度
     *
     * @param head 第一个数据节点
     * @return int 长度
     * @apiNote
     * @since 2022/12/21 9:52
     */
    public int count(ListNode head) {
        ListNode temp = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }
}
