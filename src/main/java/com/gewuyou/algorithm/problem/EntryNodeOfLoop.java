package com.gewuyou.algorithm.problem;

/**
 * 判断链表中环路路口
 *
 * @author GeWuYou
 * @version V1.0.0
 * @ClassName EntryNodeOfLoop
 * @apiNote </br>
 * @since 2022/12/18 12:26
 */
public class EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode pHead) {
        // 健壮性检验
        if (pHead == null || pHead.next == null) {
            return null;
        }
        //定义快慢指针
        ListNode fast = pHead;
        ListNode slow = pHead;
        //定义临时指针
        ListNode temp = null;
        //定义标记
        boolean flag = true;

        //遍历链表，如果快慢指针指向了同一个结点，那么证明有环
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow && flag) {
                // 关闭标记
                flag = false;
                // 为临时指针赋值
                temp = pHead;
                // 判断环入口是否与链表路口重合
                if (temp == slow) {
                    return pHead;
                }
                // 跳过后面的执行
                continue;
            }
            if (temp != null) {
                temp = temp.next;
                if (temp == slow) {
                    return slow;
                }
            }
        }
        return null;
    }
}
